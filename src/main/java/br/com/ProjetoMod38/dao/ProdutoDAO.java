package br.com.ProjetoMod38.dao;

import br.com.ProjetoMod38.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Produto produto) {
        em.persist(produto);
    }

    public List<Produto> listar() {
        return em.createQuery("from Produto", Produto.class).getResultList();
    }

    @Transactional
    public Produto atualizar(Produto produto) {
        return em.merge(produto);
    }

    @Transactional
    public void excluir(Produto produto) {
        Produto p = em.find(Produto.class, produto.getId());
        if (p != null) {
            em.remove(p);
        }
    }
}