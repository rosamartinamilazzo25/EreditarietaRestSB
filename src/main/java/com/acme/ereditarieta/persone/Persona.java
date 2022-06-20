package com.acme.ereditarieta.persone;

import com.acme.ereditarieta.citta.Citta;

public interface Persona {

	Citta getCitta();

	String getCognome();

	long getId();

	String getNome();

	void setCitta(Citta citta);

	void setCognome(String cognome);

	void setId(long id);

	void setNome(String nome);

}