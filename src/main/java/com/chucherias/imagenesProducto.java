
package com.chucherias;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import com.chucherias.entidades.Imgproducto;
import com.chucherias.entidades.Producto;
import com.chucherias.hibernate.imgproductoDAO;
 
@ManagedBean
public class imagenesProducto {
     
    private List<String> images;
    private int idProducto; 
    
    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    } 
    
    @PostConstruct
    public void init() {
        imgproductoDAO h= new imgproductoDAO();
        
        List<Imgproducto> listImg= h.getImgProducto(idProducto);
        images = new ArrayList<String>();
        for(Imgproducto img : listImg)
        {
            images.add(img.getUrl());
        }
        /*
        for (int i = 1; i <= 4; i++) {
            images.add("img" + i + ".jpg");
        }
        */
    }
 
    public List<String> getImages() {
        return images;
    }

}