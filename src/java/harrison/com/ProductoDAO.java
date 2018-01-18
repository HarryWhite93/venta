/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com;

import harrison.com.models.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harrison
 */
public class ProductoDAO extends DAO{
    
    
    public void registrar(Producto producto)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO PRODUCTO(NOMBRE,PRECIO) VALUES(?,?)");
            st.setString(1, producto.getNombre());
            st.setInt(2, producto.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }   
    public void modificar(Producto producto)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE PRODUCTO SET NOMBRE = ?, PRECIO = ? WHERE CODIGO = ?");
            st.setString(1, producto.getNombre());
            st.setInt(2, producto.getPrecio());
            st.setInt(3, producto.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }    
        
    public List<Producto> listar ()throws Exception{
        ResultSet rs;
        List<Producto> list;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT CODIGO, NOMBRE, PRECIO FROM PRODUCTO");
            rs = st.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("CODIGO"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setPrecio(rs.getInt("PRECIO"));
                list.add(producto);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public Producto leerId(Producto prooducto)throws Exception{
        ResultSet rs;
        Producto prod = null;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT CODIGO, NOMBRE, PRECIO FROM PRODUCTO WHERE CODIGO = ?");
            st.setInt(1, prooducto.getCodigo());
            rs = st.executeQuery();
            while(rs.next()){
                prod = new Producto();
                prod.setCodigo(rs.getInt("CODIGO"));
                prod.setNombre(rs.getString("NOMBRE"));
                prod.setPrecio(rs.getInt("PRECIO")); 
            }
            return prod;
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public void eliminar(Producto producto)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM PRODUCTO WHERE CODIGO = ?");
            st.setInt(1, producto.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    
    }
}
