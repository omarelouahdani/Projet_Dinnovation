package org.sid;

import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.sid.dao.AdminRepository;
import org.sid.dao.EcoleRepository;
import org.sid.dao.FiliereRepository;
import org.sid.dao.LoginRepository;
import org.sid.dao.ProfilRepository;
import org.sid.dao.PromoRepository;
import org.sid.dao.RSRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.entities.Admin;
import org.sid.entities.Ecole;
import org.sid.entities.Filiere;
import org.sid.entities.Login;
import org.sid.entities.Profil;
import org.sid.entities.Promo;
import org.sid.entities.RS;
import org.sid.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroupePersonnelApplication  implements CommandLineRunner {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	ProfilRepository profileRepository;
	@Autowired
	EcoleRepository ecoleRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	RSRepository rsRepository;
	@Autowired
	FiliereRepository filierRepository;
	@Autowired
	PromoRepository promoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GroupePersonnelApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {
	
	}	
    

}
