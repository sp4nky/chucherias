/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chucherias.hibernate;

import com.chucherias.entidades.Imgproducto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author d225364
 */
public class imgproductoDAO {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public long add(Object o) throws HibernateException {
        long id = 0;

        try {
            iniciaOperacion();
            id = (Long) sesion.save(o);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            cerrarSession(sesion);
        }

        return id;
    }

    public void update(Object o) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(o);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            cerrarSession(sesion);
        }
    }

    public void del(Object o) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(o);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            cerrarSession(sesion);
        }
    }

    public Imgproducto find(int id) throws HibernateException {
        Imgproducto o = null;
        try {
            iniciaOperacion();
            o = (Imgproducto) sesion.get(Imgproducto.class, id);
        } finally {
            cerrarSession(sesion);
        }

        return o;
    }

    public List<Imgproducto> getList() throws HibernateException {
        List<Imgproducto> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery("from Imgproducto").list();
        } finally {
            cerrarSession(sesion);
        }

        return lista;
    }

    public List<Imgproducto> getImgProducto(int id) throws HibernateException {
        List<Imgproducto> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery("from Imgproducto where idproducto=" + id).list();
        } finally {
            cerrarSession(sesion);
        }

        return lista;
    }

    private void cerrarSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

}
