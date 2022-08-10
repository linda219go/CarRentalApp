package com.example.CarRentalApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstname;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastname;
    @Column(unique = true, nullable = false, length = 40)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Car> carSet;

    public String getFullName(){
        return this.getFirstname() + " " + this.getLastname();
    }
}
