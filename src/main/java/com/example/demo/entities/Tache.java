package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="taches")
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	private @Getter @Setter String titre;
	private @Getter @Setter String description;
	private @Getter @Setter String lienProjetParent;
	@ManyToOne
    @JoinColumn(name="projet_id", nullable=true)
	private @Getter @Setter Projet projet;
}
