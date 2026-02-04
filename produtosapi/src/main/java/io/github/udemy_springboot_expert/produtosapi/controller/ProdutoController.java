package io.github.udemy_springboot_expert.produtosapi.controller;

import io.github.udemy_springboot_expert.produtosapi.model.Produto;
import io.github.udemy_springboot_expert.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        var id = UUID.randomUUID().toString(); //geração de ID nulo para id no banco
        produto.setId(id); //setando a variavel id no produto
        produtoRepository.save(produto);
        return produto;
    }
}
