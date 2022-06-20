package com.acme.ereditarieta.citta;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

@Configuration
public class CittaConfiguration {
	private static final Faker faker = new Faker( new Locale("it-IT"));
	
	@Bean("CittaFake")
	@Scope("prototype")
	public Citta newCitta() {
		Citta c = new Citta();
		
		c.setCitta(faker.address().city());
		c.setProvincia(faker.address().stateAbbr());
		
		return c;

	
	}

}
