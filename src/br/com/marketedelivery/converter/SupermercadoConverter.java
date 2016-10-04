package br.com.marketedelivery.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.managedBean.SupermercadoMB;


@FacesConverter("supermercadoConverter")
public class SupermercadoConverter implements Converter{
		
	private SupermercadoMB service;
	private IFachada fachada;
	
	public SupermercadoConverter() {
		service = new SupermercadoMB();
		fachada = new Fachada();
	}

	@SuppressWarnings("null")
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String valor) {
	
		if(valor != null && valor.trim().length() > 0) {
		 try {
			 //int aux = Integer.parseInt(valor);
//			  service = (SupermercadoMB) fc.getExternalContext().getApplicationMap().get("supermercadoMB");
//            service.getListarTodosSupermercados().indexOf(Integer.parseInt(valor));
			 List<Supermercado>retorno = fachada.listarSupermercado();
              return retorno.indexOf(Integer.parseInt(valor));
             // return service;
         } catch(NumberFormatException e) {
             throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione um supermercado", "supermercado invalido"));
             
         }
		}else{
			return null;
		}
		
		
	}
	

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null) {
			return String.valueOf(((Supermercado) object).getCodigo());
		}
		return null;
	}

}
