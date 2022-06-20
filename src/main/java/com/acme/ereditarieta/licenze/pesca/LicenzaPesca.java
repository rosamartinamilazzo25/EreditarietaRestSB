package com.acme.ereditarieta.licenze.pesca;

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
public class LicenzaPesca extends LicenzaAbstract {
	private String localita;


	public LicenzaPesca(long id, int annoScadenza, String numeroLicenza, Titolare titolare,
			String localita) {
		super(id, annoScadenza, numeroLicenza, titolare);
		this.localita=localita;
	}

}
