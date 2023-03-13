package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Tache;
import com.example.demo.repositories.TacheRepository;

@Service
public class TacheImpl implements ServiceGlobale<Tache> {
	@Autowired
	private TacheRepository tacheRepository;

	@Override
	public List<Tache> rechercher(String titre) {
		return tacheRepository.rechercher(titre);
	}

	public Tache ajouterTacheAUnProjet(Tache tache) {
		return tacheRepository.save(tache);
	}

	public boolean SupprimerTousTachesDeProjet(Long idProjet) {
		try {
			tacheRepository.SupprimerTousTachesDeProjet(idProjet);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
