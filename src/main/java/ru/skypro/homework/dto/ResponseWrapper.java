package ru.skypro.homework.dto;

import liquibase.pro.packaged.E;
import liquibase.pro.packaged.T;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class ResponseWrapper<D> {

    private int count;
    private Collection<D> results;


    public static <T> ResponseWrapper<T> of(List<T> results) {
        ResponseWrapper<T> rw = new ResponseWrapper<>();
        if (results == null) {
            return rw;
        }
        rw.results = results;
        rw.count = results.size();

        return rw;
    }
}
