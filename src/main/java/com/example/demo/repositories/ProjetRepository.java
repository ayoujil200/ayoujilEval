package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Projet;
import com.example.demo.entities.Utilisateur;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
	@Query(value = "select * from projets where titre like '%:titre%' order by id", nativeQuery = true)
	public List<Projet> rechercher(@Param("titre") String titre);

	@Transactional
	@Modifying
	@Query(name = "Projet.creerProject")
	public void creerProject(@Param("titre") String titre, @Param("description") String description, @Param("utilisateur") Utilisateur utilisateur);
}
