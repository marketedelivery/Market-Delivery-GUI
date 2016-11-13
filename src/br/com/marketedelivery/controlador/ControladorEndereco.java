package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.DAOFactory.DAOFactoryEndereco;
import br.com.marketedelivery.IDAO.IEnderecoDAO;
import br.com.marketedelivery.classesBasicas.Endereco;

public class ControladorEndereco 
{
	private IEnderecoDAO enderecoDAO;
	
	public void cadastrarEndereco(Endereco endereco)
	{
		//enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.inserir(endereco);
	}
	
	public void atualizarEndereco(Endereco endereco)
	{
		//enderecoDAO=DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.alterar(endereco);
	}
	
	public List<Endereco> listarTodosEnderecos()
	{
		//enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		return enderecoDAO.consultarTodos();
	}
	
	public Endereco pesquisarPorCep(Endereco endereco)
	{
		String cep = endereco.getCep();
		//enderecoDAO =DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarCep(cep);
		return retorno;
	}
	
	public Endereco pesquisarPorLogradouro(Endereco endereco)
	{
		String logradouro = endereco.getLogradouro();
		//enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarLogradouro(logradouro);
		return retorno;
	}
}
