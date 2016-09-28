package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Usuario;

@ViewScoped
@ManagedBean(name="usuarioMB")
public class UsuarioMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private IFachada fachada = new Fachada();
 

    public Usuario getUsuario() 
    {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public IFachada getFachada() 
    {
        return fachada;
    }

    public void setFachada(IFachada fachada) 
    {
        this.fachada = fachada;
    }
    
    public void CadastrarUsuario(Usuario usuario)
    {
    	fachada.CadastrarUsuario(usuario);
    }
}