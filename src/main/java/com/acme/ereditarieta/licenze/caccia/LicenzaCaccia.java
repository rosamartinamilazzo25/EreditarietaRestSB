package com.acme.ereditarieta.licenze.caccia;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.persone.titolari.Titolare;
import com.acme.ereditarieta.tesserini.pesca.TesserinoPesca;

import io.swagger.v3.oas.annotations.callbacks.Callback;
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
