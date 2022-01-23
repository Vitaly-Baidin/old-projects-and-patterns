package org.vitalik.currencyConverter.repository;

import org.springframework.data.repository.CrudRepository;
import org.vitalik.currencyConverter.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
