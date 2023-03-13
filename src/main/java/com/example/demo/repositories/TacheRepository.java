package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Tache;

@Repository
public interface TacheRepository extends JpaRepository <Tache, Long> {
	@Query(value = "select * from taches where titre like '%:titre%' order by id", nativeQuery = true)
	public List <Tache> rechercher(@Param("titre") String titre);
	
	@Transactional
    @Modifying
	@Query(value = "delete from taches where projet_id = :id", nativeQuery = true)
	public void SupprimerTousTachesDeProjet(@Param("id") Long id);
	
	@Query(value = "insert into taches (description,lien_projet_parent,titre,projet_id) values (:description,:lien,:titre,:projetId);", nativeQuery = true)
	public void ajouterTacheAUnProjet(@Param("projetId") Long projetId, @Param("lien") String lien, @Param("titre") String titre, @Param("description") String description);
}
