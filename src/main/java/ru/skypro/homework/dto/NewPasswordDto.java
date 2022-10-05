package ru.skypro.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewPasswordDto {

    private String currentPassword;
    private String newPassword;
}
