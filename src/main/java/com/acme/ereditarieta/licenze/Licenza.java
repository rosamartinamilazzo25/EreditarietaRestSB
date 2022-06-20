package com.acme.ereditarieta.licenze;

import com.acme.ereditarieta.persone.titolari.Titolare;

public interface Licenza {

	int getAnnoScadenza();

	long getId();

	String getNumeroLicenza();

	Titolare getTitolare();

	void setAnnoScadenza(int annoScadenza);

	void setId(long id);

	void setNumeroLicenza(String numeroLicenza);

	void setTitolare(Titolare titolare);

}