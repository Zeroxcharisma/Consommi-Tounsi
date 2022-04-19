

package tn.esprit.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.entity.Ads;
import tn.esprit.springboot.entity.Product;
import tn.esprit.springboot.service.AdsService;

@RequestMapping("/product")
@RestController
public class AdsController {
    @Autowired
    private AdsService adsService;


    //OK
    @PostMapping ("/addAds")
    public Ads addAds(@RequestBody Ads ads){
        return adsService.addAds(ads);
    }
    //OK
    @GetMapping("/getAds")
    public List<Ads> addAds(){
        return adsService.getAllAds();
    }

    //get methods

    //OK
    @GetMapping("/ADS/{idAds}")
    
    public Ads findProductById(@PathVariable int idAds)
    {
        return adsService.getAdsById(idAds);
    }

    //DONE
    //put method
    @PutMapping(value = "updateAds/{idad}")
    public void updateAds(@RequestBody Ads ads, @PathVariable("idad") int idad) {
        adsService.updateAds(ads, idad);
    }
    
    //OK
    @DeleteMapping("/delete/{idads}")
    public void deleteAdsById(@PathVariable("idads") int idAd) {
    		adsService.deleteAdsById(idAd);

    }


}

