package com.acme.ereditarieta.persone.titolari;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/titolari")
public class TitolareController {
	
	@Autowired
	private TitolareRepository titolareRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Long> getTitolare(@PathVariable long id) {
		
		if(titolareRepo.existsById(id)) {
			Optional<Titolare> tit = titolareRepo.findById(id);
		return new ResponseEntity(tit, HttpStatus.OK);
		
		} else { 
			return new ResponseEntity("Titolare n." + id + " non trovato", HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insertTitolare(@RequestBody Titolare titolare) {
		if(titolareRepo.existsById(titolare.getId())) {
		return new ResponseEntity<String>("Utente già esistente",HttpStatus.NOT_ACCEPTABLE);
		} else { 
			
			titolareRepo.save(titolare);
			return ResponseEntity.ok("Utente inserito");
			
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateTitolare(@RequestBody Titolare titolare,@PathVariable long id) {
		if(titolareRepo.existsById(id)) {
			
		
			Titolare titolareInDb = titolareRepo.findById(id).get();
			
			BeanUtils.copyProperties(titolare, titolareInDb);
			
			titolareRepo.save(titolareInDb);
			
			return new ResponseEntity<String> ("Titolare " + (long) id + "modificato", HttpStatus.OK);
			
		} else {
			return new ResponseEntity<String> ("Titolare " + (long) id + "non trovato", HttpStatus.NOT_FOUND);
		}
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTitolare(@PathVariable long id) {
		if(titolareRepo.existsById(id)) {
		titolareRepo.deleteById(id);
		return new ResponseEntity<String>("Titolare " + (long) id + "eliminato", HttpStatus.OK);
	} else {
		return new ResponseEntity<String> ("Titolare " + (long) id + "non trovato", HttpStatus.NOT_FOUND);
	}
	
	}
	
	@GetMapping
	public ResponseEntity<List<Titolare>> getTuttiTitolari() {
		return ResponseEntity.ok((List<Titolare>) titolareRepo.findAll());
	}
}
