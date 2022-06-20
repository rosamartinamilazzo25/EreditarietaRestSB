package com.acme.ereditarieta.licenze;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.ereditarieta.licenze.caccia.LicenzaCaccia;
import com.acme.ereditarieta.licenze.caccia.LicenzaCacciaRepository;
import com.acme.ereditarieta.licenze.pesca.LicenzaPesca;
import com.acme.ereditarieta.licenze.pesca.LicenzaPescaRepository;

@RestController
@RequestMapping("/licenze")
public class LicenzaController {

	public final static String LICENZA_PESCA = "Pesca";
	public final static String LICENZA_CACCIA= "Caccia";
	
	@Autowired
	LicenzaCacciaRepository licenzaCacciaRepo;
	LicenzaPescaRepository licenzaPescaRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLicenza (@PathVariable Long id, String tipoLicenza) {
		if(tipoLicenza == LICENZA_CACCIA && licenzaCacciaRepo.existsById(id)) {
			LicenzaCaccia licenzaCaccia = licenzaCacciaRepo.findById(id).get();
			
			return new ResponseEntity(licenzaCaccia, HttpStatus.OK);
		} else if (tipoLicenza == LICENZA_PESCA && licenzaPescaRepo.existsById(id)) {
			LicenzaPesca licenzaPesca = licenzaPescaRepo.findById(id).get();
			return new ResponseEntity(licenzaPesca, HttpStatus.OK);
			
		} else {
			return new ResponseEntity("Licenza " + id +  " non trovata ", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insertLicenzaCaccia( @RequestBody Licenza licenza, String tipoLicenza) {
		if(tipoLicenza == LICENZA_CACCIA && licenzaCacciaRepo.existsById(licenza.getId())) {
			return new ResponseEntity<String>("Licenza già esistente", HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			    	licenzaCacciaRepo.save((LicenzaCaccia) licenza);
			    	return ResponseEntity.ok("Licenza inserita ");
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insertLicenzaPesca(@RequestBody Licenza licenza, String tipoLicenza) {
		if(tipoLicenza == LICENZA_PESCA && licenzaPescaRepo.existsById(licenza.getId())) {
			return new ResponseEntity<String>("Licenza già esistente", HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			    	licenzaPescaRepo.save((LicenzaPesca) licenza);
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
	
	public ResponseEntity<String> updateLicenzaPesca (@RequestBody Licenza licenza, @PathVariable Long id) {
		if(licenzaPescaRepo.existsById(id)) {
			LicenzaPesca licenzaInDb = licenzaPescaRepo.findById(id).get();
			BeanUtils.copyProperties(licenza, licenzaInDb);
			licenzaPescaRepo.save(licenzaInDb);
			
			return new ResponseEntity<String> ("Licenza " + id + " modificata", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Licenza " + id + " non trovata", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/licenze")
	
	public ResponseEntity <List <LicenzaCaccia>> getTutteLeLicenzeCaccia () {
		return ResponseEntity.ok((List<LicenzaCaccia>) licenzaCacciaRepo.findAll());
	}
	
	@GetMapping("/licenze")
	
	public ResponseEntity <List <LicenzaPesca>> getTutteLeLicenzePesca () {
		return ResponseEntity.ok((List<LicenzaPesca>) licenzaPescaRepo.findAll());
	}
}
