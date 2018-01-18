/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com.beans;

import harrison.com.ProductoDAO;
import harrison.com.models.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Harrison
 */
@ManagedBean
@ViewScoped
public class productoBean {

    private Producto producto = new Producto();
    private List<Producto> lista;
    private String accion;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void registrar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.registrar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            lista = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerId(Producto producto) throws Exception {
        ProductoDAO dao;
        Producto temp;
        try {
            dao = new ProductoDAO();
            temp = dao.leerId(producto);
            if (temp != null) {
                this.producto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.modificar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Producto prod) throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.eliminar(prod);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void operar()throws Exception{
        switch (accion) {
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }
    
    public  void limpiar(){
        this.producto.setCodigo(0);
        this.producto.setNombre("");
        this.producto.setPrecio(0);
    }

}
