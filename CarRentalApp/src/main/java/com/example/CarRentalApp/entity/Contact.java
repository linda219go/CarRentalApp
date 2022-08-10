package com.example.CarRentalApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstname;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastname;
    @Column(name = "area_code", nullable = false, length = 20)
    private String areacode;
    @Column(name = "tel_num", nullable = false, length = 20)
    private String telnum;
    @Column(unique = true, nullable = false, length = 40)
    private String email;
    @Column(nullable = false, length = 200)
    private String feedback;
}
