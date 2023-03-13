package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@Query(value = "select * from utilisateurs where nom like '%:nom%' order by id", nativeQuery = true)
	public List<Utilisateur> rechercher(@Param("nom") String nom);
}
