package com.chucherias.hibernate;

import com.chucherias.entidades.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class productoDAO {

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

    public long add(Producto prod) throws HibernateException {
        long id = 0;

        try {
            iniciaOperacion();
            id = (Long) sesion.save(prod);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void update(Producto prod) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(prod);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void del(Producto prod) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(prod);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Producto find(int idProducto) throws HibernateException {
        Producto prod = null;
        try {
            iniciaOperacion();
            prod = (Producto) sesion.get(Producto.class, idProducto);
        } finally {
            sesion.close();
        }

        return prod;
    }

    public List<Producto> getList() throws HibernateException {
        List<Producto> listaProductos = null;

        try {
            iniciaOperacion();
            listaProductos = sesion.createQuery("from Producto").list();
        } finally {
            sesion.close();
        }

        return listaProductos;
    }
}
