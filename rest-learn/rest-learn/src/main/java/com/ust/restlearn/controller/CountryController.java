package com.ust.restlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.restlearn.model.Country;
import com.ust.restlearn.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService conServ;
	
	@GetMapping("/countries")
	public List<Country> getAllCountries() 
	{
		System.out.println("Fetching All");
		List<Country> countries = conServ.getAllCountries();
		return countries;
	}	
	
	@GetMapping("/countries/{code}")
	public Country getCountryById(@PathVariable String code)
	{
		return conServ.findCountryByCode(code);
	}
	
	@PostMapping("/countries")
	public Country addCountries(@RequestBody Country country) {
		 conServ.addCountry(country);
		 return country;
	}
	
	@PutMapping("/countries")
	public Country updateCountries(@RequestBody Country country) {
		conServ.updateCountry(country);
		return country;
	}
	
	@DeleteMapping("/countries/{code}")
	public void deleteCountries (@PathVariable String code) {
		conServ.deleteCountry(code);
		System.out.println("Deleted country "+code);
	}
}
