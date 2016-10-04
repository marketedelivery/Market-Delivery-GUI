package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

@ManagedBean(name="supermercadoMB", eager = true)
@ApplicationScoped
public class SupermercadoMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IFachada fachada;
	Supermercado s;
	private Supermercado supermercadoSelecionado;
	private String nomeProduto;
	
	private List<Supermercado> converterListaSuper;
	
	@PostConstruct
    public void init() {
		
	}
	public IFachada getFachada()
	{
		if(fachada == null)
		{
			return fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
	public List<Produto> listaProtudoDoSupermercado;
	
	public SupermercadoMB() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Supermercado getSupermecado(){
		if(s == null){
			s =  new Supermercado();
		}
		return s;
	}
	public List<Supermercado> getListarTodosSupermercados() {
		converterListaSuper =  new ArrayList<Supermercado>();
		converterListaSuper = getFachada().listarSupermercado();
		 return converterListaSuper;
		
	}
	
	public Supermercado getSupermercadoSelecionado() {
		return supermercadoSelecionado;
	}
	public void setSupermercadoSelecionado(Supermercado supermercadoSelecionado) {
		this.supermercadoSelecionado = supermercadoSelecionado;
	}

	
	
}
