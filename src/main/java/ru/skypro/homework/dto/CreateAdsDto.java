package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class CreateAdsDto {
    String description;
    String image;
    int pk;
    int price;
    String title;

}
