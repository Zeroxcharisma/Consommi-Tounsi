


package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Ads;

public interface IAds {
    Ads addAds(Ads ads);
    List<Ads> getAllAds();
    Ads getAdsById(int idAd);
    void updateAds(Ads ads, int idAd);
    void deleteAdsById(int idAd);
}


