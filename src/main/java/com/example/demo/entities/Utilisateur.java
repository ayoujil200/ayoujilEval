package com.example.demo.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="utilisateurs")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	private @Getter @Setter String nom;
	private @Getter @Setter String adresse;
	private @Getter @Setter String email;
	@OneToMany(mappedBy="utilisateur")
	@Column(nullable = true)
	private @Getter @Setter List <Projet> projets;
}
