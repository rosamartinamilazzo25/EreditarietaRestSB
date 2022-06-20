package com.acme.ereditarieta.licenze;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.acme.ereditarieta.licenze.caccia.LicenzaCaccia;
import com.acme.ereditarieta.licenze.pesca.LicenzaPesca;
import com.github.javafaker.Faker;

@Configuration
public class LicenzaConfiguration {
	private static final Faker faker = new Faker( new Locale("it-IT"));

	@Bean("LicenzaCaccia")
	@Scope("prototype")
	public LicenzaCaccia newLicenzaCaccia() {
		LicenzaCaccia lc = new LicenzaCaccia();
		lc.setAnnoScadenza(faker.number().numberBetween(2020, 2025));
		lc.setAtc(faker.address().cityName());
		lc.setNumeroArma(faker.number().digits(10));
		lc.setNumeroLicenza(faker.number().digits(5));
		lc.setTipoPreda(faker.pokemon().name());		
		return lc;
		
	}
	 
	@Bean("LicenzaPesca")
	@Scope("prototype")
	public LicenzaPesca newLicenzaPesca() {
		LicenzaPesca lp = new LicenzaPesca();
		lp.setAnnoScadenza(faker.number().numberBetween(2020, 2025));
		lp.setLocalita(faker.address().country());
		lp.setNumeroLicenza(faker.number().digits(5));
		return lp;
	
	
}
}	
	
