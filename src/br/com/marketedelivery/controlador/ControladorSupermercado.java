package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.IDAO.ISupermercadoDao;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ControladorSupermercado 
{
	private ISupermercadoDao supermercadoDAO;
	
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO.inserir(supermercado);
	}
	
	public void atualizarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO.alterar(supermercado);
	}
	
	public List<Supermercado>listarTodosSupermercados()
	{
		return supermercadoDAO.consultarTodos();
	}
	
	public Supermercado pesquisarPorCNPJ(Supermercado supermercado)
	{
		String cnpj = supermercado.getCnpj();
		Supermercado retorno = supermercadoDAO.buscarPorCNPJ(cnpj);
		return retorno;
	}
	
	public Supermercado pesquisarPorNome(Supermercado supermercado)
	{
		String nome = supermercado.getNome();
		Supermercado retorno = supermercadoDAO.buscarPorNome(nome);
		return retorno;
	}
}
