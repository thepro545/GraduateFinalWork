package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.AdsComment;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@Tag(name = "Объявления", description = "AdsController")
public class AdsController {

    private final AdsMapper mapper;

    private final AdsService adsService;

    public AdsController(AdsMapper mapper, AdsService adsService) {
        this.mapper = mapper;
        this.adsService = adsService;
    }

    @Operation(summary = "getAllAds", description = "getAllAds")
    @GetMapping
    public ResponseWrapper<AdsDto> getAllAds() {
        Collection<Ads> listAds = adsService.gatAllAds();

        return ResponseWrapper.of(mapper.toDto(listAds));
    }

    @Operation(summary = "addAds", description = "addAds")
    @PostMapping
    public AdsDto addAds(@RequestBody CreateAdsDto dto) {

        Ads ads = mapper.toEntity(dto);

        return mapper.toDto(adsService.createAds(ads));
    }

    @Operation(summary = "getAdsMe", description = "getAdsMe")
    @GetMapping("/me")
    public ResponseWrapper<AdsDto> getAdsMe() {
        //Заглушка
        return new ResponseWrapper<AdsDto>();
    }

    @Operation(summary = "getAdsComments", description = "getAdsComments")
    @GetMapping("/{ad_pk}/comment")
    public ResponseWrapper<AdsCommentDto> getAdsComments(@PathVariable int ad_pk) {
        //Заглушка
        return new ResponseWrapper<AdsCommentDto>();
    }

    @Operation(summary = "addAdsComments", description = "addAdsComments")
    @PostMapping("/{ad_pk}/comment")
    public AdsCommentDto addAdsComments(@PathVariable int ad_pk, @RequestBody AdsCommentDto adsCommentDto) {
        //Заглушка
        return new AdsCommentDto();
    }

    @Operation(summary = "deleteAdsComment", description = "deleteAdsComment")
    @DeleteMapping("/{ad_pk}/comment/{id}")
    public ResponseEntity deleteAdsComment(@PathVariable int ad_pk, @PathVariable long id) {
        //Заглушка
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "getAdsComment", description = "getAdsComment")
    @GetMapping("/{ad_pk}/comment/{id}")
    public AdsCommentDto getAdsComment(@PathVariable int ad_pk, @PathVariable long id) {
        //Заглушка
        return new AdsCommentDto();
    }

    @Operation(summary = "updateAdsComment", description = "updateAdsComment")
    @PatchMapping("/{ad_pk}/comment/{id}")
    public AdsCommentDto updateAdsComment(@PathVariable int ad_pk, @PathVariable long id, @RequestBody AdsCommentDto updatedAdsCommentDto) {
        //Заглушка
        return new AdsCommentDto();
    }

    @Operation(summary = "removeAds", description = "removeAds")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAds(@PathVariable long id) {

        adsService.removeAds(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "getAds", description = "getAds")
    @GetMapping("/{id}")
    public FullAdsDto getAds(@PathVariable long id) {

        return mapper.toFullAdsDto(adsService.getFullAds(id));

    }

    @Operation(summary = "updateAds", description = "updateAds")
    @PatchMapping("/{id}")
    public AdsDto updateAds(@PathVariable long id, @RequestBody AdsDto updatedAdsDto) {

        Ads updateAds = adsService.update(id, mapper.toEntity(updatedAdsDto));

        return mapper.toDto(updateAds);
    }

}
