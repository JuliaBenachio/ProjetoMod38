package br.com.ProjetoMod38.controller;

import java.io.Serializable;
import java.util.Collection;

import br.com.ProjetoMod38.model.Produto;
import br.com.ProjetoMod38.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;



@Named
@ViewScoped
public class ProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Produto produto;
    private Collection<Produto> produtos;

    @Inject
    private ProdutoService service;

    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.produto = new Produto();
            this.produtos = service.listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erro ao carregar produtos"));
        }
    }

    public void cancel() {
        this.isUpdate = false;
        this.produto = new Produto();
    }

    public void edit(Produto produto) {
        this.isUpdate = true;
        this.produto = produto;
    }

    public void delete(Produto produto) {
        try {
            service.excluir(produto);
            produtos.remove(produto);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erro ao excluir produto"));
        }
    }

    public void add() {
        try {
            service.salvar(produto);
            this.produtos = service.listar();
            this.produto = new Produto();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Produto criado com sucesso!"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erro ao criar produto"));
        }
    }

    public void update() {
        try {
            service.atualizar(this.produto);
            cancel();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Produto atualizado com sucesso!"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erro ao atualizar produto"));
        }
    }


    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }
}