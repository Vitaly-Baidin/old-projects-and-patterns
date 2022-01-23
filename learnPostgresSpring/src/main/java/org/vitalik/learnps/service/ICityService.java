package org.vitalik.learnps.service;

import org.vitalik.learnps.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
}