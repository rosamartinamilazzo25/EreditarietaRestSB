package com.acme.ereditarieta.persone.titolari;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

@Configuration
public class TitolareConfiguration {
	private static final Faker faker = new Faker( new Locale("it-IT"));
	@Bean("TitolareFake")
	@Scope("prototype")
	public Titolare newTitolare() {
		Titolare t= new Titolare();
		t.setCognome(faker.name().lastName());
		t.setNome(faker.name().firstName());
		return t;
		
	}

}
