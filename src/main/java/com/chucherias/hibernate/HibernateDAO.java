package com.chucherias.hibernate;

import com.chucherias.entidades.producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDAO {

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

    public Object find(int id) throws HibernateException {
        Object o = null;
        try {
            iniciaOperacion();
            o = (producto) sesion.get(producto.class, id);
        } finally {
            sesion.close();
        }

        return o;
    }

    public List<Object> getList(String nombreTabla) throws HibernateException {
        List<Object> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery("from " + nombreTabla).list();
        } finally {
            sesion.close();
        }

        return lista;
    }
    
    public List<Object> getListWhere(String query) throws HibernateException {
        List<Object> lista = null;

        try {
            iniciaOperacion();
            lista = sesion.createQuery(query).list();
        } finally {
            sesion.close();
        }

        return lista;
    }
}
