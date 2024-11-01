package com.presentes_casamento.presentesCasamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presentes_casamento.presentesCasamento.models.Categoria;
import com.presentes_casamento.presentesCasamento.repositories.CategoriaRepository;
import com.presentes_casamento.presentesCasamento.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
            "Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria create(Categoria obj) {
        obj.setId(null); // Para garantir que é um novo objeto
        return categoriaRepository.save(obj);
    }

    public Categoria update(Long id, Categoria obj) {
        Categoria categoriaExistente = findById(id); // Garante que a categoria existe
        categoriaExistente.setNome(obj.getNome());
        return categoriaRepository.save(categoriaExistente);
    }

    public void delete(Long id) {
        findById(id); // Verifica se a categoria existe antes de deletar
        categoriaRepository.deleteById(id);
    }
}
