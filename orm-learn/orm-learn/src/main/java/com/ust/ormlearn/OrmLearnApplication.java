package com.ust.ormlearn;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ust.ormlearn.model.Country;
import com.ust.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService; 
	
	public static void main(String[] args) {
//		SpringApplication.run(OrmLearnApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args); 
		countryService = context.getBean(CountryService.class); 
		testGetAllCountries(); 
		testFindCountryByCode();
		testAddCountry();
		testGetAllCountries();
		testUpdateCountry();
		testGetAllCountries();
		testDeleteCountry();
		testGetAllCountries();
	}

	private static void testGetAllCountries() { 
		List<Country> countries = countryService.getAllCountries();
		for(Country c : countries) {
			System.out.println(c.toString());
		}
	} 
	
	private static void testFindCountryByCode() {
		System.out.println(countryService.findCountryByCode("IN").toString());
	}
	
	private static void testAddCountry() {
		Country cnt = new Country();
		cnt.setCode("CH");
		cnt.setName("Switzer");
		countryService.addCountry(cnt);
	}
	
	private static void testUpdateCountry() {
		Country cnt = new Country();
		cnt.setCode("CH");
		cnt.setName("Switzerland");
		countryService.updateCountry(cnt);
	}
	
	private static void testDeleteCountry() {
		countryService.deleteCountry("IN");
	}
	

}
