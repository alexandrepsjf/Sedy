/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Usuario;

/**
 *
 * @author Mateu
 */
public class UsuarioDAO {
   private static UsuarioDAO instance = new UsuarioDAO();

    public static UsuarioDAO getInstance() {
        return instance;
    }

    private UsuarioDAO() {
    }
   public void salvar(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (usuario.getId() != null) {
                em.merge(usuario);
            } else {
                em.persist(usuario);
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

    
    public List<Usuario> getAllUsuarios() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Usuario> usuarios = null;
        try {
            tx.begin();
            TypedQuery<Usuario> query = em.createQuery("select Usuario from Usuario", Usuario.class);
            usuarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return usuarios;
    }

    public Usuario getUsuario(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Usuario usuario = null;
        try {
            tx.begin();
            usuario = em.find(Usuario.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return usuario;
    }
    
    public void excluir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Usuario.class, usuario.getId()));
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
