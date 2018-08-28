
package com.chucherias;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.chucherias.entidades.Producto;
 
@ManagedBean
@ViewScoped
public class girdProductos implements Serializable {
     
    private List<Producto> prod;
     
    private Producto selectedProd;
     
    @ManagedProperty("#{productoController}")
    private productoController service;
     
    @PostConstruct
    public void init() {
        prod = service.getlistProductos();
    }
 
    public List<Producto> getProd() {
        return prod;
    }
 
    public void setService(productoController service) {
        this.service = service;
    }
 
    public Producto getSelectedProd() {
        return selectedProd;
    }
 
    public void setSelectedCar(Producto selectedProd) {
        this.selectedProd = selectedProd;
    }
}
