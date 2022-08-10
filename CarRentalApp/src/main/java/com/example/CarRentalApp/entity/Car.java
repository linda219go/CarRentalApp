package com.example.CarRentalApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String type;
    private Integer year;
    private Integer price;
    private Integer numOfDays;
    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Integer getTotalCost(){
        return price*numOfDays;
    }
    public String getCarInfo(){
        return make + "/"+type+ "/" + year+ "/" + numOfDays+ " days/Total: $" + this.getTotalCost();
    }


}
