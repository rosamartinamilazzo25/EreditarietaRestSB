package com.acme.ereditarieta.licenze;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.acme.ereditarieta.persone.titolari.Titolare;
import com.acme.ereditarieta.tesserini.TesserinoAbstract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public abstract class LicenzaAbstract implements Licenza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private int annoScadenza;
	@Column(length = 30, nullable = false)
	private String numeroLicenza;
	
	@ManyToOne
	private Titolare titolare;
	
	@OneToMany(mappedBy = "licenza")
	private List<TesserinoAbstract> tesserini;


	
	//siccome l'aver inserito la lista di tesserini mi da errore nelle classi figlie
	//come se volessero che inserissi questo attributo nel costruttore ma questo non è
	//un attributo ma una relazione, specifico come è fatto il costruttore della classe
	//tasto destro source--> generate construct from using field e levo tessrini
	public LicenzaAbstract(long id, int annoScadenza, String numeroLicenza, Titolare titolare) {
		this.id = id;
		this.annoScadenza = annoScadenza;
		this.numeroLicenza = numeroLicenza;
		this.titolare = titolare;
	}
	
	
	

}
