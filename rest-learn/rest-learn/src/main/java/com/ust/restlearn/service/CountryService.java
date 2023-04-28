package com.ust.restlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.restlearn.model.Country;
import com.ust.restlearn.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository conRepo;
	
	@Transactional
	public List<Country> getAllCountries(){
		return conRepo.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) {
		return conRepo.findById(countryCode).get();
	}
	
	@Transactional
	public void addCountry(Country country) {
		System.out.println("Adding");
		conRepo.save(country);
	}
	
	@Transactional
	public void updateCountry(Country country) {
		System.out.println("Updating");
		Country c= findCountryByCode(country.getCode());
		if(c!=null)
			conRepo.save(country);
		
	}
	
	@Transactional
	public void deleteCountry(String countryCode){
		System.out.println("Deleting");
		conRepo.deleteById(countryCode);
	}
}
