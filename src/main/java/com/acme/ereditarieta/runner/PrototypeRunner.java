package com.acme.ereditarieta.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.acme.ereditarieta.citta.Citta;
import com.acme.ereditarieta.citta.CittaRepository;
import com.acme.ereditarieta.licenze.caccia.LicenzaCaccia;
import com.acme.ereditarieta.licenze.caccia.LicenzaCacciaRepository;
import com.acme.ereditarieta.licenze.pesca.LicenzaPesca;
import com.acme.ereditarieta.licenze.pesca.LicenzaPescaRepository;
import com.acme.ereditarieta.persone.titolari.Titolare;
import com.acme.ereditarieta.persone.titolari.TitolareRepository;
import com.acme.ereditarieta.tesserini.caccia.TesserinoCaccia;
import com.acme.ereditarieta.tesserini.caccia.TesserinoCacciaRepository;
import com.acme.ereditarieta.tesserini.pesca.TesserinoPesca;
import com.acme.ereditarieta.tesserini.pesca.TesserinoPescaRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PrototypeRunner implements ApplicationRunner {

	@Autowired
	CittaRepository cittaRepo;
	@Autowired
	TitolareRepository titolareRepo;
	@Autowired
	LicenzaCacciaRepository licenzaCacciaRepo;
	@Autowired
	LicenzaPescaRepository licenzaPescaRepo;
	@Autowired
	TesserinoCacciaRepository tesserinoCacciaRepo;
	@Autowired
	TesserinoPescaRepository tesserinoPescaRepo;
	
	
	@Autowired
	@Qualifier("CittaFake")
	ObjectProvider<Citta> cittaProvider;
	
	@Autowired
	@Qualifier("TitolareFake")
	ObjectProvider<Titolare> titolareProvider;

	
	@Autowired
	@Qualifier("LicenzaCaccia")
	ObjectProvider<LicenzaCaccia> licenzaCacciaProvider;
	@Autowired
	@Qualifier("LicenzaPesca")
	ObjectProvider<LicenzaPesca> licenzaPescaProvider;
	
	
	@Autowired
	@Qualifier("TesserinoCaccia")
	ObjectProvider<TesserinoCaccia> tesserinoCacciaProvider;
	@Autowired
	@Qualifier("TesserinoPesca")
	ObjectProvider<TesserinoPesca> tesserinoPescaProvider;
	

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("========Runner Partito===========");
		for (int i = 0; i < 10; i++) {
			Citta c = cittaProvider.getObject();
			cittaRepo.save(c);
			System.out.println(c);
			
			Titolare t = titolareProvider.getObject();
			t.setCitta(c);
			titolareRepo.save(t);
			System.out.println(t);
			
			LicenzaCaccia lc= licenzaCacciaProvider.getObject();
			lc.setTitolare(t);
			licenzaCacciaRepo.save(lc);
			System.out.println(lc);
			
			LicenzaPesca lp= licenzaPescaProvider.getObject();
			lp.setTitolare(t);
			licenzaPescaRepo.save(lp);
			System.out.println(lp);
			
			TesserinoCaccia tc= tesserinoCacciaProvider.getObject();
			tc.setLicenza(lc);
			tesserinoCacciaRepo.save(tc);
			System.out.println(tc);
			
			TesserinoPesca tp= tesserinoPescaProvider.getObject();
			tp.setLicenza(lp);
			tesserinoPescaRepo.save(tp);
			System.out.println(tp);
			
		
			
		}
		
	}

}
