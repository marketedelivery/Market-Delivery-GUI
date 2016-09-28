package br.com.marketedelivery.controlador;


import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryPerfil;
import br.com.marketedelivery.IDAO.IPerfilDAO;
import br.com.marketedelivery.classesBasicas.Perfil;

public class ControladorPerfil 
{
	private IPerfilDAO perfilDAO;
	
	public void CadastrarPerfil(Perfil perfil)
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		perfilDAO.inserir(perfil);
	}
	
	public void AtualizarPerfil(Perfil perfil)
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		perfilDAO.alterar(perfil);
	}
	
	public List<Perfil>ListarTodosPerfil()
	{
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		return perfilDAO.consultarTodos();
	}
	
	public Perfil PesquisarPorCodigo(Perfil perfil)
	{
		int codigo = perfil.getCodigo();
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		Perfil retorno = perfilDAO.consultarPorId(codigo);
		return retorno;
		
	}
	
	public Perfil PesquisarPorNome(Perfil perfil)
	{
		String nome = perfil.getNome();
		perfilDAO = DAOFactoryPerfil.getPerfilDAO();
		Perfil retorno = perfilDAO.BuscarPorNome(nome);
		return retorno;
	}
}
