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
import model.Ligacao;

public class LigacaoDAO {

     private static LigacaoDAO instance = new LigacaoDAO();

    public static LigacaoDAO getInstance() {
        return instance;
    }

    private LigacaoDAO() {
    }

    public void salvar(Ligacao ligacao) {
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

    public List<Ligacao> getAllLigacao() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Ligacao> ligacao = null;
        try {
            tx.begin();
            TypedQuery<Ligacao> query = em.createQuery("select Ligacao from Ligacao", Ligacao.class);
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

    public Ligacao getLigacao(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Ligacao ligacao = null;
        try {
            tx.begin();
            ligacao = em.find(Ligacao.class, id);
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

    public void excluir(Ligacao ligacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Ligacao.class, ligacao.getId()));
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
    

