package com.acme.ereditarieta.licenze.caccia;

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
@RequestMapping("/licenzeCaccia")
public class LicenzaCacciaController {
	@Autowired
	LicenzaCacciaRepository licenzaCacciaRepo;

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLicenza (@PathVariable long id) {
		if(licenzaCacciaRepo.existsById(id)) {
			LicenzaCaccia licenzaCaccia = licenzaCacciaRepo.findById(id).get();
			
			return new ResponseEntity(licenzaCaccia, HttpStatus.OK);
			}	else {
				return new ResponseEntity("Licenza " + id +  " non trovata ", HttpStatus.NOT_FOUND);
			}
	}
	@PostMapping
	public ResponseEntity<String> insertLicenzaCaccia( @RequestBody Licenza licenza) {
		if(licenzaCacciaRepo.existsById(licenza.getId())) {
			return new ResponseEntity<String>("Licenza già esistente", HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			    	licenzaCacciaRepo.save((LicenzaCaccia) licenza);
			    	return ResponseEntity.ok("Licenza inserita ");
		}
	}
	
@PutMapping("/{id}")
	
	public ResponseEntity<String> updateLicenzaCaccia (@RequestBody Licenza licenza, @PathVariable Long id) {
		if(licenzaCacciaRepo.existsById(id)) {
			LicenzaCaccia licenzaInDb = licenzaCacciaRepo.findById(id).get();
			BeanUtils.copyProperties(licenza, licenzaInDb);
			licenzaCacciaRepo.save(licenzaInDb);
			
			return new ResponseEntity<String> ("Licenza " + id + " modificata", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Licenza " + id + " non trovata", HttpStatus.NOT_FOUND);
		}
	}

@GetMapping("/licenzeCaccia")

public ResponseEntity <List <LicenzaCaccia>> getTutteLeLicenzeCaccia () {
	return ResponseEntity.ok((List<LicenzaCaccia>) licenzaCacciaRepo.findAll());
}

@DeleteMapping("{/id}")
public ResponseEntity<String> deleteLicenza (@PathVariable  long id) {
	 if(licenzaCacciaRepo.existsById(id)) {
		 licenzaCacciaRepo.deleteById(id);
		 return new ResponseEntity<String> ("Licenza "  + id + " cancellata", HttpStatus.OK);
	 } else {
		 return new ResponseEntity<String> ("Licenza " + id + " non trovata ", HttpStatus.NOT_FOUND); 
	 }
}
}
