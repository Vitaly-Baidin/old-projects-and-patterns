package org.vitalik.currencyConverter.service;

import org.vitalik.currencyConverter.model.Currency;

import java.util.List;

public interface IXMLService {
    List<Currency> parseCurrency(String URL);
}
