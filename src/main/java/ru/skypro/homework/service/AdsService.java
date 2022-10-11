package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.AdsCommentDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.AdsComment;

import java.util.Collection;

public interface AdsService {
    Ads createAds(Ads ads);

    Ads getFullAds(long id);

    Collection<Ads> getAllAds();

    boolean removeAds(long id, Authentication authentication);

    Ads updateAds(long id, Ads updatedAdsDto, Authentication authentication);

    Collection<Ads> getAdsMe();

    AdsComment addAdsComment(long adPk, AdsComment adsComment);

    Collection<AdsComment> getAdsComments(long adPk);

    AdsComment getAdsComment(long adPk, long id);

    boolean deleteAdsComment(long adPk, long id, Authentication authentication);

    AdsComment updateAdsComment(long adPk, long id, AdsComment toEntity, Authentication authentication);
}

