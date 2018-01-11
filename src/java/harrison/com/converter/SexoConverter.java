/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Harrison
 */
@FacesConverter("sexoConverter")
public class SexoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String sexo="";
        
        if(value!=null){
            sexo = (String) value;
            
            switch(sexo){
                    case "M":
                        sexo = "Masculino";
                        break;
                    case "F":
                        sexo = "Femenino";
                        break;
            }            
        }
        return sexo;
    }
    
}
