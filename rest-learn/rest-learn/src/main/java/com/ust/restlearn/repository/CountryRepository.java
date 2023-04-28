package com.ust.restlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.restlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
