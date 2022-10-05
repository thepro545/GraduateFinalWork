package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.AdsComment;

import java.util.Collection;

public interface AdsService {
    Ads createAds(Ads ads);

    Ads getFullAds(long id);

    Collection<Ads> getAllAds();

    boolean removeAds(long id, Authentication authentication);

    Ads update(long id, Ads updatedAdsDto, Authentication authentication);

    Collection<Ads> getAdsMe();

    AdsComment addAdsComment(long ad_pk, AdsComment adsComment);
}

