
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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class productoController {
    
    private Producto selected;
    private List<Producto> listProd;
    private List<Imgproducto> listImg;
    private productoDAO hprod;
    private imgproductoDAO h;
    private int idProducto;
    
    @PostConstruct
    public void init() {
        h= new imgproductoDAO();
        
        
    }
    
    public String prepareView(){
        //selected = hprod.find(idProducto);
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("producto", getIdProducto());
        
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
        listImg= h.getImgProducto(idProducto);
        return listImg;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
}
