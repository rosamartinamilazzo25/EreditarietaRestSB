package com.acme.ereditarieta.licenze.pesca;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.licenze.caccia.LicenzaCaccia;
import com.acme.ereditarieta.persone.titolari.Titolare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Entity
public class LicenzaPesca extends LicenzaAbstract {
	private String localita;


	public LicenzaPesca(long id, int annoScadenza, String numeroLicenza, Titolare titolare,
			String localita) {
		super(id, annoScadenza, numeroLicenza, titolare);
		this.localita=localita;
	}

}
