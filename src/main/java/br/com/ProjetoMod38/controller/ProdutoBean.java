package br.com.ProjetoMod38.controller;

import br.com.ProjetoMod38.model.Produto;
import br.com.ProjetoMod38.service.ProdutoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ProdutoBean {

    private Produto produto = new Produto();

    @Inject
    private ProdutoService service;


    public void salvar() {
        service.salvar(produto);
        produto = new Produto();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Produto salvo com sucesso!"));
    }

    public List<Produto> getProdutos() {
        return service.listar();
    }

    public Produto getProduto() {
        return produto;
    }
}