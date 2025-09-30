package com.example.money_converter.controller;

import com.example.money_converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class MoneyCurrencyController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/convert")
    public ResponseEntity<Double> convert(@RequestParam(value = "from") String from,
                                  @RequestParam(value = "to") String to,
                                  @RequestParam(value = "amount") Double value) {

        Double rate = currencyService.convert(from, to, value);
        return ResponseEntity.ok(rate);
    }

}
