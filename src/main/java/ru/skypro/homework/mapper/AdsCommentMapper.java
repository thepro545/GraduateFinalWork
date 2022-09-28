package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.entity.AdsComment;
import ru.skypro.homework.mapper.WebMapper;

@Mapper
public interface AdsCommentMapper extends WebMapper<AdsCommentDto, AdsComment> {

    @Override
    @Mapping(target = "author.id", source = "author")
    AdsComment toEntity(AdsCommentDto dto);

    @Override
    @Mapping(target = "author", source = "author.id")
    AdsCommentDto toDto(AdsComment entity);
}
