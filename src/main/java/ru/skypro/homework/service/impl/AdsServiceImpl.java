package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;

    public AdsServiceImpl(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }


    @Override
    public Ads createAds(Ads ads) {

        //тут надо как то получать автора и добавлять его в объект Ads
        //проверки на null и тд.

        return adsRepository.save(ads);
    }

    @Override
    public Ads getFullAds(long id) {

        return adsRepository.findById(id).orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));
    }

    @Override
    public Collection<Ads> gatAllAds() {
        return adsRepository.findAll();
    }

    @Override
    public void removeAds(long id) {
        Ads ads = adsRepository.findById(id).orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));

        adsRepository.delete(ads);
    }

    @Override
    public Ads update(long id, Ads updatedAdsDto) {

        Ads ads = adsRepository.findById(id).orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));

        updatedAdsDto.setAuthor(ads.getAuthor());
        updatedAdsDto.setId(ads.getId());
        updatedAdsDto.setDescription(ads.getDescription());

        return adsRepository.save(updatedAdsDto);
    }
}
