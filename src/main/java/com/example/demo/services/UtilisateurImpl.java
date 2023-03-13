package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Projet;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;

@Service
public class UtilisateurImpl implements ServiceGlobale <Utilisateur> {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public List<Utilisateur> rechercher(String nom) {
		return utilisateurRepository.rechercher(nom);
	}
	
	public Utilisateur create(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}
	
	public boolean deleteById(Long id) {
		try {
			utilisateurRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void getById(Long id) {
		utilisateurRepository.findById(id);
	}

}
