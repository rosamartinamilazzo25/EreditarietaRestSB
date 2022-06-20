package com.acme.ereditarieta.tesserini.pesca;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.tesserini.TesserinoAbstract;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TesserinoPesca extends TesserinoAbstract {


	public TesserinoPesca(long id, String numeroTesserino, int annoScadenza, LicenzaAbstract licenza) {
		super(id, numeroTesserino, annoScadenza, licenza);
	
	}

}
