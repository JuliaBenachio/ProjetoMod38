package br.com.ProjetoMod38.dao;

import br.com.ProjetoMod38.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Produto produto) {
        em.persist(produto);
    }

    public List<Produto> listar() {
        return em.createQuery("from Produto", Produto.class).getResultList();
    }
}