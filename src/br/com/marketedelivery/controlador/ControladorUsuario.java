package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryUsuario;
import br.com.marketedelivery.IDAO.IUsuarioDAO;
import br.com.marketedelivery.classesBasicas.Usuario;

public class ControladorUsuario 
{
	private IUsuarioDAO usuarioDAO;
	
	public void cadastrarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.inserir(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.alterar(usuario);
	}
	
	public List<Usuario>listarCliente()
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		return usuarioDAO.consultarTodos();
	}
	
	public Usuario listarPorCPF(Usuario usuario)
	{
		String cpf = usuario.getCpf();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorCPF(cpf); 
		return retorno;
	}
	
	public Usuario listarPorNome(Usuario usuario)
	{
		String nome = usuario.getNome();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorNome(nome);
		return retorno;
	}
}
