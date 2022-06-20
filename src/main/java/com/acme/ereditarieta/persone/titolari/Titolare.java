package com.acme.ereditarieta.persone.titolari;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.acme.ereditarieta.citta.Citta;
import com.acme.ereditarieta.licenze.Licenza;
import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.acme.ereditarieta.persone.PersonaAbstract;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true) //aggiunge la stampa degli attributi della classe papà nelle sottoclassi

@Entity
public class Titolare extends PersonaAbstract {
	
	@ToString.Exclude
	@JsonIgnoreProperties({"titolari"})
	@ManyToOne
	private Citta citta;
	
	@ToString.Exclude
	@JsonIgnoreProperties({"titolare"})
	@OneToMany(mappedBy = "titolare")
	private List<LicenzaAbstract> licenze;


	public Titolare(long id, String nome, String cognome, Citta citta) {
		super(id, nome, cognome);
		this.citta=citta;
		
	}

}
