package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.DAO.FacesUtil;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Usuario;

@ViewScoped
@ManagedBean(name="usuarioMB")
public class UsuarioMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private Endereco endereco;
    private IFachada fachada;
    private List<Usuario> listar;
 
    
    
    public Endereco getEndereco()
    {
    	if(endereco == null)
    	{
    		endereco = new Endereco();
    	}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() 
    {
		if(usuario==null)
		{
			usuario = new Usuario();
		}
        return usuario;
    }

    public IFachada getFachada() 
    {
    	if(fachada == null)
    	{
    		fachada=new Fachada();
    	}
        return fachada;
    }
  
	public void setFachada(IFachada fachada) 
    {
        this.fachada = fachada;
    }
	
    public List<Usuario> getListar() 
    {
		return listar;
	}

	public void setListar(List<Usuario> listar) {
		this.listar = listar;
	}

	public void salvar()
    {	
    	IFachada fachada = getFachada();
    	Usuario usuario = getUsuario();
    	Endereco end = getEndereco();
       	usuario.setEndereco(end);
    	fachada.CadastrarUsuario(usuario);
    	FacesUtil.adicionarMsgInfo("Cadastrado com Sucesso");
    }
    
    public void listarUsuario()
    {
    	IFachada fachada = getFachada();
    	listar = fachada.ListarTodosUsuarios();
    }
}