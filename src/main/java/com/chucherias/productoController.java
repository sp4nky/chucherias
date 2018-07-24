
package com.chucherias;

import com.chucherias.entidades.imgproductos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.chucherias.entidades.producto;
import com.chucherias.hibernate.imgproductoDAO;
import com.chucherias.hibernate.productoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@SessionScoped
public class productoController {
    
    private producto selected;
    private List<producto> listProd;
    private List<imgproductos> listImg;
    private productoDAO hprod;
    private imgproductoDAO h;
    
    @PostConstruct
    public void init() {
        h= new imgproductoDAO();
        
        
    }
    
    public String prepareView(int id){
        //selected = hprod.find(id);
        listImg= h.getImgProducto(id);
        return "producto";
    }
    
    public List<producto> getlistProductos() {
        if (listProd == null) {
            listProd = hprod.getList();
        }
        return listProd;
    }
    
}
