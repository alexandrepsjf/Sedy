/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Sujajeb
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.FormaPgm;

public class FormaPagamentoDAO {

    private static FormaPagamentoDAO instance = new FormaPagamentoDAO();

    public static FormaPagamentoDAO getInstance() {
        return instance;
    }

    private FormaPagamentoDAO() {
    }

    public void salvar(FormaPgm formaPagamento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (formaPagamento.getId() != null) {
                em.merge(formaPagamento);
            } else {
                em.persist(formaPagamento);
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

    public List<FormaPgm> getAllFormaPagamento() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<FormaPgm> formasPagamento = null;
        try {
            tx.begin();
            TypedQuery<FormaPgm> query = em.createQuery("select f from FormaPgm f", FormaPgm.class);
            formasPagamento = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return formasPagamento;
    }

    public FormaPgm getFormaPagamento(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        FormaPgm formaPagamento = null;
        try {
            tx.begin();
            formaPagamento = em.find(FormaPgm.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return formaPagamento;
    }

    public void excluir(FormaPgm formaPagamento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(FormaPgm.class, formaPagamento.getId()));
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
        public void alterar(FormaPgm forma) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(forma);
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
