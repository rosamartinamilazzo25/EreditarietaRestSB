package com.acme.ereditarieta.licenze.pesca;

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

import com.acme.ereditarieta.licenze.Licenza;
import com.acme.ereditarieta.licenze.pesca.LicenzaPescaRepository;

@RestController
@RequestMapping("/licenzePesca")
public class LicenzaPescaController {
	@Autowired
	LicenzaPescaRepository licenzaPescaRepo;

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLicenza (@PathVariable long id) {
		if(licenzaPescaRepo.existsById(id)) {
			LicenzaPesca licenzaPesca = licenzaPescaRepo.findById(id).get();
			
			return new ResponseEntity(licenzaPesca, HttpStatus.OK);
			}	else {
				return new ResponseEntity("Licenza " + id +  " non trovata ", HttpStatus.NOT_FOUND);
			}
	}
	@PostMapping
	public ResponseEntity<String> insertLicenzaPesca( @RequestBody Licenza licenza) {
		if(licenzaPescaRepo.existsById(licenza.getId())) {
			return new ResponseEntity<String>("Licenza già esistente", HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			    	licenzaPescaRepo.save((LicenzaPesca) licenza);
			    	return ResponseEntity.ok("Licenza inserita ");
		}
	}
	
@PutMapping("/{id}")
	
	public ResponseEntity<String> updateLicenzaPesca(@RequestBody Licenza licenza, @PathVariable long id) {
		if(licenzaPescaRepo.existsById(id)) {
			LicenzaPesca licenzaInDb = licenzaPescaRepo.findById(id).get();
			BeanUtils.copyProperties(licenza, licenzaInDb);
			licenzaPescaRepo.save(licenzaInDb);
			
			return new ResponseEntity<String> ("Licenza " + id + " modificata", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Licenza " + id + " non trovata", HttpStatus.NOT_FOUND);
		}
	}
 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteLicenza (@PathVariable  long id) {
	 if(licenzaPescaRepo.existsById(id)) {
		 licenzaPescaRepo.deleteById(id);
		 return new ResponseEntity<String> ("Licenza "  + id + " cancellata", HttpStatus.OK);
	 } else {
		 return new ResponseEntity<String> ("Licenza " + id + " non trovata ", HttpStatus.NOT_FOUND); 
	 }
 }
@GetMapping("/licenzePesca")

public ResponseEntity <List <LicenzaPesca>> getTutteLeLicenzeCaccia () {
	return ResponseEntity.ok((List<LicenzaPesca>) licenzaPescaRepo.findAll());
}
}
