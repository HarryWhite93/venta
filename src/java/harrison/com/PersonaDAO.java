/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com;

import harrison.com.models.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Harrison
 */
public class PersonaDAO extends DAO{
    
    public void registrar(Persona persona)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("INSERT INTO PERSONA (NOMBRE,SEXO) VALUES(?,?)");
            st.setString(1, persona.getNombre());
            st.setString(2, persona.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<Persona> listar()throws Exception{
         List<Persona> lista;
         ResultSet rs;
         try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT Codigo,"
                                                                   +" NOMBRE,"
                                                                   + " SEXO"
                                                              +" FROM PERSONA");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setSexo(rs.getString("sexo"));
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        }finally{
             this.Cerrar();
         }
         return lista;
    }
    
}
