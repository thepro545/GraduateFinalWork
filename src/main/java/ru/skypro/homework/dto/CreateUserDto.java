package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class CreateUserDto {

    String email;
    String firstName;
    String lastName;
    String password;
    String phone;
}
