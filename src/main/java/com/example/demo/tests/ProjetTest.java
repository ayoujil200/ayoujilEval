package com.example.demo.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Tache;
import com.example.demo.entities.Utilisateur;
import com.example.demo.entities.Projet;
import com.example.demo.services.ProjetImpl;
import com.example.demo.services.UtilisateurImpl;

@SpringBootTest
public class ProjetTest {
	@Autowired
	private ProjetImpl projetService;
	
	@Autowired
	private UtilisateurImpl utilisateurService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testCreerProjet() {
		Utilisateur u = new Utilisateur();
		u.setAdresse("r");
		u.setEmail("e");
		u.setNom("n");
		u.setProjets(null);
		Utilisateur returnedUser = utilisateurService.create(u);
		assertNotNull(returnedUser);
		
		assertTrue(projetService.creerProject("t1", "d1", returnedUser));
	}

	/*@Test
	public void testChecherProjet() {
		for (Projet p : projetService.rechercher("t1")) {
			System.out.println(p.getId());
		}
	}*/
}