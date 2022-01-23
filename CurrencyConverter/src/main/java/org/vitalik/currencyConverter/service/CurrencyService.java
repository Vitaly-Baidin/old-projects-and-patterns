package org.vitalik.currencyConverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.vitalik.currencyConverter.model.Currency;
import org.vitalik.currencyConverter.repository.CurrencyRepository;

import java.util.List;

public class CurrencyService implements ICurrencyService{

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findAll() {
        return null;
    }
}
