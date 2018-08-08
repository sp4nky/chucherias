
package com.chucherias;

import com.chucherias.entidades.Imgproducto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.chucherias.entidades.Producto;
import com.chucherias.hibernate.imgproductoDAO;
import com.chucherias.hibernate.productoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@SessionScoped
public class productoController {
    
    private Producto selected;
    private List<Producto> listProd;
    private List<Imgproducto> listImg;
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
    
    public List<Producto> getlistProductos() {
        if (getListProd() == null) {
            listProd = hprod.getList();
        }
        return getListProd();
    }

    /**
     * @return the listProd
     */
    public List<Producto> getListProd() {
        return listProd;
    }

    /**
     * @return the listImg
     */
    public List<Imgproducto> getListImg() {
        return listImg;
    }
    
}
