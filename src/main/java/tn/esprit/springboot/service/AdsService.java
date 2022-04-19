package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.Ads;
import tn.esprit.springboot.repository.AdsRepository;

@Service  //aamaltha besh mbaad n injicteha ka dependance fl controller aka injection de dep
public class AdsService implements IAds{

    @Autowired //injectit type ads repo eli besh yorbet maa service
    AdsRepository adsRepository;

    @Override
    public Ads addAds(Ads ads) {
        return adsRepository.save(ads);

    }

    @Override
    public List<Ads> getAllAds() {
        return adsRepository.findAll();
    }

    @Override
    public Ads getAdsById(int idAd) {
        return adsRepository.findById(idAd).get();
    }

    @Override
    public void updateAds(Ads ads, int idAd) {
        if (adsRepository.findById(idAd).orElse(null) != null)
            ads.setIdAd(idAd);
        adsRepository.save(ads);


    }

    @Override
    public void deleteAdsById(int idAd) {
        adsRepository.deleteById(idAd);

    }
}
