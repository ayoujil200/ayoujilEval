package com.example.demo.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Utilisateur;
import com.example.demo.services.UtilisateurImpl;

@SpringBootTest
public class UtilisateurTest {
	@Autowired
	private UtilisateurImpl utilisateurService;
	
	@Test
	public void contextLoads() {

	}
	
	@Test
	public void testDeleteById() {
		Utilisateur u = new Utilisateur();
		u.setAdresse("r");
		u.setEmail("e");
		u.setNom("n");
		u.setProjets(null);
		Utilisateur returnedUser = utilisateurService.create(u);
		assertEquals(utilisateurService.deleteById(returnedUser.getId()), true);
	}
}
