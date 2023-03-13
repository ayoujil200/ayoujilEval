package com.example.demo.entities;

import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "projets")
@NamedQuery(name = "Projet.creerProject", query = "insert into Projet (titre, description, utilisateur) values(:titre, :description, :utilisateur)")
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	private @Getter @Setter String titre;
	private @Getter @Setter String description;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = true)
	private @Getter @Setter Utilisateur utilisateur;
	@OneToMany(mappedBy = "projet")
	@Column(nullable = true)
	private @Getter @Setter List<Tache> taches;
}
