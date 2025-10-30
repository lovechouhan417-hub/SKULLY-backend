package com.skully.skully.dto;

import lombok.Data;

@Data
public class RegisterRequest {


    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String email;
    private String password;
    private String villageName;
    private String districtName;


}
