package br.edu.ifrs.canoas.ancient.converter;

import java.io.Serializable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifrs.canoas.ancient.bean.BaseEntity;



@FacesConverter("generic")
public class Conversor implements Converter {  
    
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
        if (value != null) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;  
    }  
  
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
  
        if (value != null  
                && !"".equals(value)) {  
  
            BaseEntity entity = (BaseEntity) value;  
  
            // adiciona item como atributo do componente  
            this.addAttribute(component, entity);  
  
            Long codigo = (Long) entity.getId();  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return value.toString();  
    }  
  
    protected void addAttribute(UIComponent component, BaseEntity o) {  
    	if (o.getId() != null){ 
    		String key = o.getId().toString(); // codigo da empresa como chave neste caso  
            this.getAttributesFrom(component).put(key, o);	
    	}
    }  
  
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }  
  
}  