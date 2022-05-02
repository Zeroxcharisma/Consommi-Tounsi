package tn.esprit.springboot.service;





import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;

import http.PaymentIntentDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${stripe.key.secret}")
    String secretKey;


    public Charge chargeCreditCard(String token,  PaymentIntentDto  paymentIntentDto ) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount",paymentIntentDto.getAmount()*100);
        chargeParams.put("currency",paymentIntentDto.getCurrency());
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
}

