package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ResponseWrapper <T>{

    int count;
    T results;
}
