package br.com.marketedelivery.controlador;

import java.util.List;
import java.util.Random;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IUsuarioDAO;
import br.com.marketedelivery.classesBasicas.Usuario;

public class ControladorUsuario
{
	private IUsuarioDAO usuarioDAO;

	public void cadastrarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.inserir(usuario);
		DAOFactory.close();
	}

	public void atualizarUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.alterar(usuario);
		DAOFactory.close();
	}

	public List<Usuario> listarTodosUsuarios()
	{
		DAOFactory.abrir();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		List<Usuario> lista = usuarioDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Usuario listarPorCPF(Usuario usuario)
	{
		DAOFactory.abrir();
		String cpf = usuario.getCpf();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorCPF(cpf);
		DAOFactory.close();
		return retorno;
	}

	public Usuario listarPorNome(Usuario usuario)
	{
		DAOFactory.abrir();
		String nome = usuario.getNome();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorNome(nome);
		DAOFactory.close();
		return retorno;
	}

	public Usuario pesquisarUsuarioPorCodigo(Usuario usuario)
	{
		DAOFactory.abrir();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario cp = usuarioDAO.consultarPorId(usuario.getCodigo());
		DAOFactory.close();
		return cp;
	}

	public Usuario pesquisarPorEmail(Usuario usuario)
	{
		DAOFactory.abrir();
		String email = usuario.getEmail();
		// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarPorEmail(email);
		DAOFactory.close();
		return retorno;
	}

	/**
	 * metodo que recupera a senha do usuário
	 * 
	 * @return String
	 */
	public String geraSenha()
	{
		Random gerador = new Random();
		StringBuilder bilder = new StringBuilder();
		// imprime sequência de 10 números inteiros aleatórios
		for (int i = 0; i < 9; i++)
		{
			// System.out.println(gerador.nextInt(9));
			bilder.append(Integer.toString(gerador.nextInt(10)));
		}
		return bilder.toString();
	}

	/**
	 * metodo que altera a senha do usuario
	 * 
	 * @param u
	 * @return boolean
	 */
	public boolean alteraSenha(Usuario u)
	{
		DAOFactory.abrir();
		boolean resultado = false;
		// Usuario usuario = new Usuario();
		// usuario = pesquisarPorEmail(u);
		if (u != null)
		{
			String senhaGerada = geraSenha();
			u.setSenha(senhaGerada);
			// usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
			usuarioDAO = DAOFactory.getUsuarioDAO();
			usuarioDAO.alterar(u);
			resultado = true;
		}
		resultado = false;
		DAOFactory.close();
		return resultado;
	}
}