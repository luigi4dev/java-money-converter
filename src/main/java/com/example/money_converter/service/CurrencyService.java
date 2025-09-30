package com.example.money_converter.service;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.money_converter.model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService{

    private final RestTemplate restTemplate = new RestTemplate();
    private String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private String API_URL_V6 = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/";

    public Double convert(String from, String to, Double amount){
        String url= API_URL + from;
        Double rate = 1.0;

        CurrencyResponse response=restTemplate.getForObject(url, CurrencyResponse.class);
        if(response!=null && response.getRates().containsKey(to.toUpperCase())){
            rate = response.getRates().get(to.toUpperCase());
        }
        return rate * amount;
    }

    private HttpURLConnection getRequest(String url){
        URL URL;
        HttpURLConnection request = null;
        try {
            URL = new URL(url);
            request = (HttpURLConnection) URL.openConnection();
        } catch (Exception e) {

        }
        return request;
    }

}