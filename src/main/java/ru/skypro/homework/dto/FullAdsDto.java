package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class FullAdsDto {

    String authorFirstName;
    String authorLastName;
    String description;
    String email;
    String image;
    String phone;
    int pk;
    int price;
    String title;
}
