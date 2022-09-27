package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ResponseWrapper <T>{

    private int count;
    private T results;
}
