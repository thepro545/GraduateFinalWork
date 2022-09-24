package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class AdsCommentDto {

    int author;
    String createdAt;
    int pk;
    String text;

}
