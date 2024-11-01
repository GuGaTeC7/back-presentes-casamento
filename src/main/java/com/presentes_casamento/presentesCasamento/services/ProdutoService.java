package com.presentes_casamento.presentesCasamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presentes_casamento.presentesCasamento.models.Produto;
import com.presentes_casamento.presentesCasamento.repositories.ProdutoRepository;
import com.presentes_casamento.presentesCasamento.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    public Produto findById(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException(
            "Produto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()
        ));  
    }

    public Produto create(Produto obj) {
        obj.setId(null);
        return produtoRepository.save(obj);
    }

    public Produto update(Long id, Produto obj) {
        Produto produtoExistente = findById(id);
        produtoExistente.setNome(obj.getNome());
        produtoExistente.setValor(obj.getValor());
        produtoExistente.setFoto(obj.getFoto());
        produtoExistente.setLink_loja(obj.getLink_loja());
        produtoExistente.setImg_loja(obj.getImg_loja());
        produtoExistente.setObservacao(obj.getObservacao());
        produtoExistente.setCategoria(obj.getCategoria());
        return produtoRepository.save(produtoExistente);
    }

    public void delete(Long id) {
        findById(id);  // Garante que o produto existe antes de deletar
        produtoRepository.deleteById(id);
    }
}
