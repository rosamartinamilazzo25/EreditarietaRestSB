package com.acme.ereditarieta.tesserini;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.acme.ereditarieta.licenze.Licenza;
import com.acme.ereditarieta.licenze.LicenzaAbstract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public abstract class TesserinoAbstract implements Tesserino {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false, length = 30)
	private String numeroTesserino;
	
	private int annoScadenza;
	
	@ToString.Exclude
	@JsonIgnoreProperties({"tesserini"})
	@ManyToOne
	private LicenzaAbstract licenza;
}
