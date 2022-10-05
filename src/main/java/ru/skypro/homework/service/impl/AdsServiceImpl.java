package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.AdsComment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.AdsCommentRepository;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;

    private final AdsCommentRepository adsCommentRepository;
    private final UserRepository userRepository;

    public AdsServiceImpl(AdsRepository adsRepository, AdsCommentRepository adsCommentRepository, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.adsCommentRepository = adsCommentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Ads createAds(Ads ads) {

        User user = userRepository.findByEmail(SecurityContextHolder.getContext()
                .getAuthentication().getName()).orElseThrow();

        ads.setAuthor(user);

        return adsRepository.save(ads);
    }

    @Override
    public Ads getFullAds(long id) {

        return adsRepository.findById(id).orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));
    }

    @Override
    public Collection<Ads> getAllAds() {
        return adsRepository.findAll();
    }

    @Override
    public boolean removeAds(long id, Authentication authentication) {

        Ads ads = adsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));

        User user = userRepository.findByEmail(authentication.getName()).orElseThrow();

        if(ads.getAuthor().getEmail().equals(user.getEmail()) || user.getRole().equals("ADMIN")){
            adsRepository.delete(ads);
            return true;
        }

        return false;

    }

    @Override
    public Ads update(long id, Ads updatedAdsDto, Authentication authentication) {

        Ads ads = adsRepository.findById(id).orElseThrow(() -> new NotFoundException("Объявление с id " + id + " не найдено!"));


        User user = userRepository.findByEmail(authentication.getName()).orElseThrow();

        if(ads.getAuthor().getEmail().equals(user.getEmail()) || user.getRole().equals("ADMIN")){
            updatedAdsDto.setAuthor(ads.getAuthor());
            updatedAdsDto.setId(ads.getId());
            updatedAdsDto.setDescription(ads.getDescription());

            return adsRepository.save(updatedAdsDto);
        }

        return updatedAdsDto;
    }

    @Override
    public Collection<Ads> getAdsMe() {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext()
                .getAuthentication().getName()).orElseThrow();

        return adsRepository.findAll().stream()
                .filter(ads -> ads.getAuthor().equals(user)).collect(Collectors.toList());


    }

    @Override
    public AdsComment addAdsComment(long ad_pk, AdsComment adsComment) {

        User user = userRepository.findByEmail(SecurityContextHolder.getContext()
                .getAuthentication().getName()).orElseThrow();

        adsComment.setAuthor(user);
        adsComment.setAds(adsRepository.findById(ad_pk).orElseThrow());
        adsComment.setCreatedAt(LocalDateTime.now());

        return adsCommentRepository.save(adsComment);

    }
}
