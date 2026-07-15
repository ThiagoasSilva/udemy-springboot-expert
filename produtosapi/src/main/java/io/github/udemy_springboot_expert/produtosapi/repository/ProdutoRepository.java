package io.github.udemy_springboot_expert.produtosapi.repository;

import io.github.udemy_springboot_expert.produtosapi.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, String> {

    List<Produto> findByNome(String nome);

}
