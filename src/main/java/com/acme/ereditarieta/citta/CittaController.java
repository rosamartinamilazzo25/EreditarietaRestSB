package com.acme.ereditarieta.citta;

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
@RequestMapping("/citta")
public class CittaController {
	
 @Autowired
 CittaRepository cittaRepo;
 
 	//recupero citta per id
 	@GetMapping("/{id}")
 	public ResponseEntity<?> getCitta (@PathVariable long id) {
 		if (cittaRepo.existsById(id)) {
 			Citta c= cittaRepo.findById(id).get();
 			return ResponseEntity.ok(c);
 		
 		}else {
 			return new ResponseEntity("Citta non trovata", HttpStatus.NOT_FOUND);
 			
 		}
 		
 	}	
 	// Inserimento POST
 		@PostMapping
 		public ResponseEntity<String> insertCitta(@RequestBody Citta citta){
 			if(cittaRepo.existsById(citta.getId())) {
 				return new ResponseEntity<String> ("Citta già esistente", HttpStatus.NOT_ACCEPTABLE);
 				
 			}else {
 				cittaRepo.save(citta);
 				return ResponseEntity.ok("Citta inserita");
 			}
 		}
 		
 		
 		
 	// Modifica  PUT	
 	@PutMapping("/{id}")
 	public ResponseEntity<String> updateCitta(@RequestBody Citta citta, @PathVariable long id){
 		if(cittaRepo.existsById(id)) {
 			Citta cittaInDb= cittaRepo.findById(id).get();
 			BeanUtils.copyProperties(citta, cittaInDb);
 			cittaRepo.save(cittaInDb);
 			return ResponseEntity.ok("Città modificata");
 			
 		} else {
 			return new ResponseEntity<String> ("Città non trovata", HttpStatus.NOT_FOUND);
 		}
 	}
 		
 	// Cancellazione DELETE
 	@DeleteMapping("/{id}")
 	public ResponseEntity<String> deleteCitta(@PathVariable long id){
 		if(cittaRepo.existsById(id)) {
 			cittaRepo.deleteById(id);
 			return ResponseEntity.ok("Citta Cancellata");
 		} else {
 			return new ResponseEntity<String> ("Citta non trovata", HttpStatus.NOT_FOUND);
 		}
 		
 	}
 	//Recupero di tutte le citta
 	@GetMapping("/citta")
 	public ResponseEntity<List<Citta>> getTutteLeCitta(){
 		return ResponseEntity.ok((List<Citta>) cittaRepo.findAll());
 	}
 	
 				
	

}
