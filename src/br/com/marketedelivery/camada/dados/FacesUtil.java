/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marketedelivery.camada.dados;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Junior
 */
public class FacesUtil {

    public static void adicionarMsgInfo(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext facesContex = FacesContext.getCurrentInstance();
        facesContex.addMessage(null, facesMessage);
    }

    public static void adicionarMsgErro(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext facesContex = FacesContext.getCurrentInstance();
        facesContex.addMessage(null, facesMessage);
    }

    public static String getParam(String nome) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContex.getExternalContext();
        Map<String, String> parametros = externalContext.getRequestParameterMap();
        String valor = parametros.get(nome);
        return valor;
    }

}
