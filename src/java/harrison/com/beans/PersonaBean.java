/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com.beans;

import harrison.com.PersonaDAO;
import harrison.com.models.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Harrison
 */
@ManagedBean
@RequestScoped
public class PersonaBean {

   private Persona persona = new Persona();
   private List<Persona> lstPersonas;
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
   
   public void registrar()throws Exception{
       PersonaDAO dao;
       
       try {
           dao = new PersonaDAO();
           dao.registrar(persona);
       } catch (Exception e) {
           throw e;
       }
   }
   
   public void listar()throws Exception{
       PersonaDAO dao;
       
       try {
           dao = new PersonaDAO();
           lstPersonas = dao.listar();
       } catch (Exception e) {
           throw e;
       }
   }
}
