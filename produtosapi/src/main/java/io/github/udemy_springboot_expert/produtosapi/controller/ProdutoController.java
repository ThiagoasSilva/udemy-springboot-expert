package io.github.udemy_springboot_expert.produtosapi.controller;

import io.github.udemy_springboot_expert.produtosapi.model.Produto;
import io.github.udemy_springboot_expert.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") String id){
        // Optional<Produto> produto = produtoRepository.findById(id);
        // return produto.isPresent() ? produto.get() : null;
        // OU de uma maneira mais simple abaixo
        return produtoRepository.findById(id).orElse(null);
    }

    @RequestMapping("/buscatudo")
    public Produto buscarTudo(@RequestBody Produto produto){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.get(produtos.size());
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable String id){
        System.out.println("Produto deletado: " + id);
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
  //public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
  //produto.setId(id);
  //Alternativa para usar a conversão automática do uuid do spring
    public void atualizar(@PathVariable UUID id, @RequestBody Produto produto){
        produto.setId(String.valueOf(id)); //value of para converter o uuid para string
        produtoRepository.save(produto);
    }
}
