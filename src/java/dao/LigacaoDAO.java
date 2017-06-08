/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Ligacoes;

public class LigacaoDAO {

     private static LigacaoDAO instance = new LigacaoDAO();

    public static LigacaoDAO getInstance() {
        return instance;
    }

    private LigacaoDAO() {
    }

    public void salvar(Ligacoes ligacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (ligacao.getId() != null) {
                em.merge(ligacao);
            } else {
                em.persist(ligacao);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public List<Ligacoes> getAllLigacao() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Ligacoes> ligacao = null;
        try {
            tx.begin();
            TypedQuery<Ligacoes> query = em.createQuery("select l from Ligacoes l", Ligacoes.class);
            ligacao = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return ligacao;
    }

    public Ligacoes getLigacao(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Ligacoes ligacao = null;
        try {
            tx.begin();
            ligacao = em.find(Ligacoes.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return ligacao;
    }

    public void excluir(Ligacoes ligacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Ligacoes.class, ligacao.getId()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }
    
}
    

