package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {

    private final AdsMapper mapper;

    private final AdsService adsService;

    public AdsController(AdsMapper mapper, AdsService adsService) {
        this.mapper = mapper;
        this.adsService = adsService;
    }

    @GetMapping
    public ResponseWrapper<AdsDto> getAllAds() {
        Collection<Ads> listAds = adsService.gatAllAds();

        return ResponseWrapper.of(mapper.toDto(listAds));
    }

    @PostMapping
    public AdsDto addAds(@RequestBody CreateAdsDto dto) {

        Ads ads = mapper.toEntity(dto);

        return mapper.toDto(adsService.createAds(ads));
    }

    @GetMapping("/{id}")
    public FullAdsDto getFullAds(@PathVariable long id) {

        return mapper.toFullAdsDto(adsService.getFullAds(id));

    }


}
