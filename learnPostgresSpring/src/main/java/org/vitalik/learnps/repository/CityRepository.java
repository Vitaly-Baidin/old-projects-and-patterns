package org.vitalik.learnps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitalik.learnps.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}