package com.acme.ereditarieta.tesserini;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.ereditarieta.tesserini.caccia.TesserinoCaccia;
import com.acme.ereditarieta.tesserini.pesca.TesserinoPesca;
import com.github.javafaker.Faker;

@Component
public class TesserinoConfiguration {
	private static final Faker faker = new Faker( new Locale("it-IT"));
	
	@Bean("TesserinoCaccia")
	@Scope("prototype")
	public TesserinoCaccia newTesserinoCaccia() {
		TesserinoCaccia tc= new TesserinoCaccia();
		tc.setAnnoScadenza(faker.number().numberBetween(2020, 2025));
		tc.setNumeroTesserino(faker.number().digits(5));
		return tc;
		
	}

	@Bean("TesserinoPesca")
	@Scope("prototype")
	public TesserinoPesca newTesserinoPesca() {
		TesserinoPesca tp= new TesserinoPesca();
		tp.setAnnoScadenza(faker.number().numberBetween(2020, 2025));
		tp.setNumeroTesserino(faker.number().digits(5));
		return tp;
	
	
}
}
