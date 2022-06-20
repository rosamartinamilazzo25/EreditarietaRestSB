package com.acme.ereditarieta.tesserini;

import com.acme.ereditarieta.licenze.LicenzaAbstract;

public interface Tesserino {

	int getAnnoScadenza();

	long getId();

	LicenzaAbstract getLicenza();

	String getNumeroTesserino();

	void setAnnoScadenza(int annoScadenza);

	void setId(long id);

	void setLicenza(LicenzaAbstract licenza);

	void setNumeroTesserino(String numeroTesserino);

}