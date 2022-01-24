package org.vitalik.currencyConverter.service;

import org.vitalik.currencyConverter.model.Currency;
import org.vitalik.currencyConverter.model.Rate;

import java.util.List;

public interface IXMLService {
    List<Currency> parseCurrency(String URL);
    List<Rate> parseRate(String URL);
}
