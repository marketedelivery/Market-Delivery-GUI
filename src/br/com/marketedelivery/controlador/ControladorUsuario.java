package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryUsuario;
import br.com.marketedelivery.IDAO.IUsuarioDAO;
import br.com.marketedelivery.classesBasicas.Usuario;

public class ControladorUsuario 
{
	private IUsuarioDAO usuarioDAO;
	
	public void CadastrarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.inserir(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario)
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		usuarioDAO.alterar(usuario);
	}
	
	public List<Usuario>ListarTodosUsuarios()
	{
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		return usuarioDAO.consultarTodos();
	}
	
	public Usuario ListarPorCPF(Usuario usuario)
	{
		String cpf = usuario.getCpf();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorCPF(cpf); 
		return retorno;
	}
	
	public Usuario ListarPorNome(Usuario usuario)
	{
		String nome = usuario.getNome();
		usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
		Usuario retorno = usuarioDAO.buscarUsuarioPorNome(nome);
		return retorno;
	}
	

    public Usuario pesquisarUsuarioPorCodigo(Usuario usuario) 
    {
        usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
        Usuario cp = usuarioDAO.consultarPorId(usuario.getCodigo());
        return cp;
       
    }
    
    public Usuario pesquisarPorEmail(Usuario usuario)
    {
    	String email = usuario.getEmail();
    	usuarioDAO = DAOFactoryUsuario.getUsuarioDAO();
    	Usuario retorno = usuarioDAO.buscarPorEmail(email);
    	return retorno;
    	
    }
}
