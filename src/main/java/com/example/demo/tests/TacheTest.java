package com.example.demo.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import com.example.demo.entities.Utilisateur;
import com.example.demo.services.ProjetImpl;
import com.example.demo.services.TacheImpl;
import com.example.demo.services.UtilisateurImpl;

@SpringBootTest
public class TacheTest {
	@Autowired
	private TacheImpl tacheService;
	
	@Autowired
	private ProjetImpl projetService;
	
	@Autowired
	private UtilisateurImpl utilisateurService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testAjouterUneTacheAUnProjet() {
		Utilisateur u = new Utilisateur();
		u.setAdresse("r");
		u.setEmail("e");
		u.setNom("n");
		u.setProjets(null);
		Utilisateur returnedUser = utilisateurService.create(u);
		assertNotNull(returnedUser);
		Projet p = new Projet();
		p.setDescription("e");
		p.setTaches(null);
		p.setTitre("t1");
		p.setUtilisateur(returnedUser);
		Projet returnedProjet = projetService.create(p);
		assertNotNull(returnedProjet);
		Tache t = new Tache();
		t.setDescription("d1");
		t.setId((long) 1);
		t.setLienProjetParent("l1");
		t.setTitre("t1");
		t.setProjet(returnedProjet);
		assertNotNull(tacheService.ajouterTacheAUnProjet(t));
	}
	
	@Test
	public void SupprimerTousTachesDeProjet() {
		Projet p = new Projet();
		p.setDescription("e");
		p.setTaches(null);
		p.setTitre("t1");
		p.setUtilisateur(null);
		Projet returnedProject = projetService.create(p);
		assertNotNull(returnedProject);
		
		Tache t1 = new Tache();
		t1.setDescription("d1");
		t1.setId((long) 1);
		t1.setLienProjetParent("l1");
		t1.setTitre("t1");
		t1.setProjet(returnedProject);
		Tache returnedTache1 = tacheService.ajouterTacheAUnProjet(t1);
		assertNotNull(returnedTache1);
		
		Tache t2 = new Tache();
		t2.setDescription("d1");
		t2.setId((long) 1);
		t2.setLienProjetParent("l1");
		t2.setTitre("t1");
		t2.setProjet(returnedProject);
		Tache returnedTache2 = tacheService.ajouterTacheAUnProjet(t2);
		assertNotNull(returnedTache2);
		
		Tache t3 = new Tache();
		t3.setDescription("d1");
		t3.setId((long) 1);
		t3.setLienProjetParent("l1");
		t3.setTitre("t1");
		t3.setProjet(returnedProject);
		Tache returnedTache3 = tacheService.ajouterTacheAUnProjet(t3);
		assertNotNull(returnedTache3);
		
		assertEquals(tacheService.SupprimerTousTachesDeProjet(returnedProject.getId()), true);
	}
}
