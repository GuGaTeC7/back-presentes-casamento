package com.presentes_casamento.presentesCasamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.presentes_casamento.presentesCasamento.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    
} 
