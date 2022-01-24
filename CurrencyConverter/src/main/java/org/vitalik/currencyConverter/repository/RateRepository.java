package org.vitalik.currencyConverter.repository;

import org.springframework.data.repository.CrudRepository;
import org.vitalik.currencyConverter.model.Rate;

public interface RateRepository extends CrudRepository<Rate, Integer> {
}
