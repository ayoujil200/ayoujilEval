package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Projet;

public interface ServiceGlobale <T> {
	public List<T> rechercher(String query);
}
