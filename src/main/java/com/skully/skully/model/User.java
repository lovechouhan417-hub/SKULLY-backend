package com.skully.skully.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// // Register payload → {
//   "FirstName": "Ram",
//   "LastName": "Singh",
//   "mobileNumber": 1234567891,
//   "villageName": "Indore",
//   "DistrictName": "Gorakhpur",
//   "email": "www.google.com"
// }

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long mobileNumber;
    private String villageName;
    private String districtName;

   
}
