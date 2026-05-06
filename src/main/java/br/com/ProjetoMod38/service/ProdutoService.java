package br.com.ProjetoMod38.service;

import br.com.ProjetoMod38.dao.ProdutoDAO;
import br.com.ProjetoMod38.model.Produto;
import jakarta.inject.Inject;
import java.util.List;

public class ProdutoService {

    @Inject
    private ProdutoDAO dao;

    public void salvar(Produto p) {
        dao.salvar(p);
    }

    public List<Produto> listar() {
        return dao.listar();
    }
}