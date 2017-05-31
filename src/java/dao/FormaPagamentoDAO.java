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
import model.FormaPagamento;

public class FormaPagamentoDAO {

    private static FormaPagamentoDAO instance = new FormaPagamentoDAO();

    public static FormaPagamentoDAO getInstance() {
        return instance;
    }

    private FormaPagamentoDAO() {
    }

    public void salvar(FormaPagamento formaPagamento) {
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

    public List<FormaPagamento> getAllFormaPagamento() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<FormaPagamento> formasPagamento = null;
        try {
            tx.begin();
            TypedQuery<FormaPagamento> query = em.createQuery("select FormaPagamento from FormaPagamento", FormaPagamento.class);
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

    public FormaPagamento getFormaPagamento(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        FormaPagamento formaPagamento = null;
        try {
            tx.begin();
            formaPagamento = em.find(FormaPagamento.class, id);
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

    public void excluir(FormaPagamento formaPagamento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(FormaPagamento.class, formaPagamento.getId()));
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
