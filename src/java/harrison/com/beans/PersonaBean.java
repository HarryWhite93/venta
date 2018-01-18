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
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Harrison
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

   private Persona persona = new Persona();
   private List<Persona> lstPersonas;
   private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
   
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
   
   private void registrar()throws Exception{
       PersonaDAO dao;
       
       try {
           dao = new PersonaDAO();
           dao.registrar(persona);
           this.listar();
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
   
   public  void leerId(Persona per)throws Exception{
       PersonaDAO dao;
       Persona temp;
       try {
           dao = new PersonaDAO();
           temp = dao.leerId(per);
           if(temp != null){
               this.persona = temp;
               this.accion = "Modificar";
           }
       } catch (Exception e) {
           throw e;
       }
   }
   
   private void modificar()throws Exception{
       PersonaDAO dao;
       try {
           dao = new PersonaDAO();
           dao.modificar(persona);
           this.listar();
       } catch (Exception e) {
           throw e;
       }
   }
   
   public void eliminar(Persona persona)throws Exception{
   PersonaDAO dao;
       try {
           dao = new PersonaDAO();
           dao.eliminar(persona);
           this.listar();
       } catch (Exception e) {
           throw e;
       }
    
   }
   
      public void operar()throws Exception{
        switch(accion){
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar" :
                this.modificar();
                this.limpiar();
                break;
        }
    }
      public void limpiar()throws Exception{
        this.persona.setCodigo(0);
        this.persona.setNombre("");
        this.persona.setSexo("");
      }
}
