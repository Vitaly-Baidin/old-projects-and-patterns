package org.vitalik.currencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.vitalik.currencyConverter.model.Currency;
import org.vitalik.currencyConverter.repository.CurrencyRepository;
import org.vitalik.currencyConverter.service.ICurrencyService;
import org.vitalik.currencyConverter.service.IXMLService;

import java.util.List;

@Controller
public class myController {

    @Autowired
    private IXMLService ixmlService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/init")
    public void parseCBR() {
        List<Currency> currencies = ixmlService.parseCurrency("http://www.cbr.ru/scripts/XML_daily.asp");
        currencyRepository.saveAll(currencies);
    }
}
