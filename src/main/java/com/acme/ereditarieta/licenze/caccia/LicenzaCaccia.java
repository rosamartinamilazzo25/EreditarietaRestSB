package com.acme.ereditarieta.licenze.caccia;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.persone.titolari.Titolare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LicenzaCaccia extends LicenzaAbstract {
	private String atc;
	private String numeroArma;
	private String tipoPreda;


	public LicenzaCaccia(long id, int annoScadenza, String numeroLicenza, Titolare titolare,
			String atc, String numeroArma, String tipoPreda) {
		super(id, annoScadenza, numeroLicenza, titolare);
		this.atc=atc;
		this.numeroArma=numeroArma;
		this.tipoPreda=tipoPreda;
		
	}

}
