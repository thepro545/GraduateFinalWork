package ru.skypro.homework.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.service.impl.UserServiceImpl;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AdsMapper extends WebMapper<AdsDto, Ads> {

    @Override
    @Mapping(target = "author.id", source = "author")
    @Mapping(target = "image", ignore = true)
    @Mapping(source = "pk", target = "id")
    Ads toEntity(AdsDto dto);

    @Override
    @Mapping(target = "author", source = "author.id")
    @Mapping(source = "id", target = "pk")
    @Mapping(target = "image", expression = "java(\"/ads/images/\" + entity.getImage().getId())")
    AdsDto toDto(Ads entity);


    @Mapping(target = "author", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(source = "pk", target = "id")
    Ads toEntity(CreateAdsDto dto);

    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    @Mapping(target = "phone", source = "author.phone")
    @Mapping(target = "email", source = "author.email")
    @Mapping(target = "image", expression = "java(\"/ads/images/\" + entity.getImage().getId())")
    FullAdsDto toFullAdsDto(Ads entity);

}
