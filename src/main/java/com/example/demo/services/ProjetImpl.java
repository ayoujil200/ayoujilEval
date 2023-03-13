package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Projet;
import com.example.demo.entities.Tache;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.ProjetRepository;

@Service
public class ProjetImpl implements ServiceGlobale <Projet> {
	@Autowired
	private ProjetRepository projetRepository;

	@Override
	public List<Projet> rechercher(String titre) {
		return projetRepository.rechercher(titre);
	}
	
	public boolean creerProject(String titre, String description, Utilisateur utilisateur) {
		try {
			projetRepository.creerProject(titre, description, utilisateur);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Projet create(Projet p) {
		return projetRepository.save(p);
	}
	
	public Optional<Projet> getById(Long id) {
		return projetRepository.findById(id);
	}
}
