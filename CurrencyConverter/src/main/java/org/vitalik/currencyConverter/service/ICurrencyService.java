package org.vitalik.currencyConverter.service;

import org.vitalik.currencyConverter.model.Currency;

import java.util.List;

public interface ICurrencyService {
    List<Currency> findAll();
}
