package ru.skypro.homework.mapper;

import liquibase.pro.packaged.E;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface WebMapper <D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDto(Collection<E> dto);

    List<E> toEntity(Collection<D> dto);
}
