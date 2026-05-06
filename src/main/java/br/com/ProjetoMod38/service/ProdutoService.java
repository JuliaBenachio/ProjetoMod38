package br.com.ProjetoMod38.service;

import br.com.ProjetoMod38.dao.ProdutoDAO;
import br.com.ProjetoMod38.model.Produto;
import jakarta.inject.Inject;
import java.util.List;

public class ProdutoService {

    @Inject
    private ProdutoDAO dao;

    public void salvar(Produto produto) {
        dao.salvar(produto);
    }

    public List<Produto> listar() {
        return dao.listar();
    }

    public void atualizar(Produto produto) {
        dao.atualizar(produto);
    }

    public void excluir(Produto produto) {
        dao.excluir(produto);
    }
}