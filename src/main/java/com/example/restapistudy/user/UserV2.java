package com.example.restapistudy.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFilter("UserInfoV2")
public class UserV2 extends User {
    private String grade;

}