package com.acme.ereditarieta.tesserini.caccia;

import javax.persistence.Entity;

import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.persone.titolari.Titolare;
import com.acme.ereditarieta.tesserini.TesserinoAbstract;
import com.acme.ereditarieta.tesserini.pesca.TesserinoPesca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Entity
public class TesserinoCaccia extends TesserinoAbstract {


	public TesserinoCaccia(long id, String numeroTesserino, int annoScadenza, LicenzaAbstract licenza) {
		super(id, numeroTesserino, annoScadenza, licenza);
		
	}

	}


