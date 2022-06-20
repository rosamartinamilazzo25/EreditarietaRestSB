package com.acme.ereditarieta.citta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.acme.ereditarieta.persone.Persona;
import com.acme.ereditarieta.persone.titolari.Titolare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Citta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String citta;
	@Column(length = 2, nullable = false)
	private String provincia;


	@OneToMany(mappedBy = "citta")
	private List<Titolare> titolari;
}
