package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IEnderecoDAO;
import br.com.marketedelivery.classesBasicas.Endereco;

public class ControladorEndereco
{
	private IEnderecoDAO enderecoDAO;

	public void cadastrarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		// enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.inserir(endereco);
		DAOFactory.close();
	}

	public void atualizarEndereco(Endereco endereco)
	{
		DAOFactory.abrir();
		// enderecoDAO=DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		enderecoDAO.alterar(endereco);
		DAOFactory.close();
	}

	public List<Endereco> listarTodosEnderecos()
	{
		DAOFactory.abrir();
		// enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		List<Endereco> lista = enderecoDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Endereco pesquisarPorCep(Endereco endereco)
	{
		DAOFactory.abrir();
		String cep = endereco.getCep();
		// enderecoDAO =DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarCep(cep);
		DAOFactory.close();
		return retorno;
	}

	public Endereco pesquisarPorLogradouro(Endereco endereco)
	{
		DAOFactory.abrir();
		String logradouro = endereco.getLogradouro();
		// enderecoDAO = DAOFactoryEndereco.getEnderecoDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		Endereco retorno = enderecoDAO.pesquisarLogradouro(logradouro);
		DAOFactory.close();
		return retorno;
	}
}