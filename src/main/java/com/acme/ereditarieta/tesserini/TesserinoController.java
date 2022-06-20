package com.acme.ereditarieta.tesserini;

import java.util.List;

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
@RequestMapping("/tesserini")
public class TesserinoController {
	@Autowired
	TesserinoRepository tesserinoRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTesserino(@PathVariable long id) {
		if (tesserinoRepository.existsById(id)) {
			Tesserino t = tesserinoRepository.findById(id).get();
			return new ResponseEntity(t, HttpStatus.OK);
		} else {
			return new ResponseEntity("Tesserino di id " + id + " non trovato.", 
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insertTesserino(@RequestBody Tesserino t) {
		if(tesserinoRepository.existsById(t.getId())) {
			return new ResponseEntity<String>("Tesserino gia' esistente.", HttpStatus.NOT_ACCEPTABLE);
		} else {
			tesserinoRepository.save((TesserinoAbstract)t);
			
			return ResponseEntity.ok("Tesserino inserito.");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTesserino(@RequestBody Tesserino t, 
			@PathVariable long id) {
		if (tesserinoRepository.existsById(id)) {
			Tesserino tesserinoInDB = tesserinoRepository.findById(id).get();	
			BeanUtils.copyProperties(t, tesserinoInDB);
			tesserinoRepository.save((TesserinoAbstract)tesserinoInDB);
			
			return new ResponseEntity("Tesserino di id " + id + "modificato.", 
					HttpStatus.OK);
		} else {
			return new ResponseEntity("Tesserino di id " + id + " non trovato.", 
					HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{idTesserino}")
	public ResponseEntity<String> deleteTesserino(@PathVariable(name = "idTesserino") 
		long id) {
		if(tesserinoRepository.existsById(id)) {
			tesserinoRepository.deleteById(id);
			
			return new ResponseEntity<String>("Tesserino di id " + id + "eliminato", 
					HttpStatus.OK);
		} else {
			return new ResponseEntity<String> ("Tesserino di id " + id + "non trovato", 
					HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public List<TesserinoAbstract> getTuttiTesserini() {
		return (List<TesserinoAbstract>) tesserinoRepository.findAll();
	}
}
