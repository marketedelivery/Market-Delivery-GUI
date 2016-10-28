package br.com.marketedelivery.IFachada;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Pagamento;
// import br.com.marketedelivery.classesBasicas.Perfil;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.classesBasicas.Usuario;

public interface IFachada
{
	public void cadastrarUsuario(Usuario usuario);

	public void atualizarUsuario(Usuario usuario);

	public List<Usuario> listarTodosUsuarios();

	public Usuario listarPorNome(Usuario usuario);

	public Usuario listarPorCPF(Usuario usuario);

	public Usuario pesquisarPorCodigo(Usuario usuario);

	public Usuario pesquisarPorEmail(Usuario usuario);

	public Usuario efetuarLogin(Usuario usuario);

	public boolean alteraSenha(Usuario u);
	// --------------------------------------------- Supermercado
	// -------------------------------------------------------------------

	public void cadastrarSupermercado(Supermercado supermercado);

	public void atualizarSupermercado(Supermercado supermercado);

	public List<Supermercado> listarTodosSupermercados();

	public Supermercado pesquisarPorCodigo(Supermercado supermercado);

	public Supermercado listarPorNome(Supermercado supermercado);

	public List<Produto> listarProdutosDoSupermercado(String nomeProduto, String supermercado);

	public Supermercado consultarPorID(Supermercado supermercado);
	// --------------------------------------------- Endereco
	// -------------------------------------------------------------------

	public void cadastrarEndereco(Endereco endereco);

	public void atualizarEndereco(Endereco endereco);

	public List<Endereco> listarEndereco();

	public Endereco listarPorCep(Endereco endereco);

	public Endereco listarPorLogradouro(Endereco endereco);

	// --------------------------------------------- Lista de Compra
	// -------------------------------------------------------------------
	public void cadastrarLista(ListaDeCompras lista);

	public void atualizarLista(ListaDeCompras lista);

	public List<ListaDeCompras> listarTodasListas();

	public ListaDeCompras buscarPorCodigo(ListaDeCompras lista);
	
	public List<ListaDeCompras> buscarListaPorUsuario(Usuario usuario) ;
	// --------------------------------------------- Perfil
	// -------------------------------------------------------------------

	/*
	 * public void CadastrarPerfil(Perfil perfil); public void
	 * AtualizarPerfil(Perfil perfil); public List<Perfil> ListarTodosPerfil();
	 * public Perfil PesquisarPorCodigo(Perfil perfil); public Perfil
	 * PesquisarPorNome(Perfil perfil);
	 */
	// --------------------------------------------- Produto
	// -------------------------------------------------------------------
	public void cadastrarProduto(Produto produto);

	public void atualizarProduto(Produto produto);

	public List<Produto> listarTodosProdutos();

	public Produto pesquisarProdutoPorNome(Produto produto);

	public Produto pesquisarPorCodigo(Produto produto);

	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado);

	// --------------------------------------------- Pagamento
	// -------------------------------------------------------------------
	public void cadastrarPagamento(Pagamento pagamento);

	public void atualizarPagamento(Pagamento pagamento);

	public List<Pagamento> listarTodosPagamentos();
	
	public Pagamento listarPorCodigo(Pagamento pagamento);

	// --------------------------------------------- Item
	// -------------------------------------------------------------------
	public void cadastrarItem(Item item);

	public void atualizarItem(Item item);

	public List<Item> listarTodosItens();
}
