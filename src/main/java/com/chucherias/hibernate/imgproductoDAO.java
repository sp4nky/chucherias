/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chucherias.hibernate;

import com.chucherias.entidades.imgproductos;
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
            sesion.close();
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
            sesion.close();
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
            sesion.close();
        }
    }

    public imgproductos find(int id) throws HibernateException {
        imgproductos o = null;
        try {
            iniciaOperacion();
            o = (imgproductos) sesion.get(imgproductos.class, id);
        } finally {
            sesion.close();
        }

        return o;
    }

    public List<imgproductos> getList() throws HibernateException {
        List<imgproductos> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery("from imgproducto").list();
        } finally {
            sesion.close();
        }

        return lista;
    }
    
    public List<imgproductos> getImgProducto(int id) throws HibernateException {
        List<imgproductos> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery("from imgproducto where imgproducto.idproducto="+id).list();
        } finally {
            sesion.close();
        }

        return lista;
    }
    
}
