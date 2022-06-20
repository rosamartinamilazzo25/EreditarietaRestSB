package com.acme.ereditarieta.tesserini.caccia;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.tesserini.TesserinoAbstract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class TesserinoCaccia extends TesserinoAbstract {


	public TesserinoCaccia(long id, String numeroTesserino, int annoScadenza, LicenzaAbstract licenza) {
		super(id, numeroTesserino, annoScadenza, licenza);
		
	}

	}


