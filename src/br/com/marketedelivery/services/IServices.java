package br.com.marketedelivery.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.classesBasicas.Perfil;
// import br.com.marketedelivery.classesBasicas.Perfil;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.classesBasicas.Usuario;

@Path("/service")
public interface IServices
{
	// Métodos
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarUsuario")
	public void cadastrarUsuario(Usuario usuario);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarUsuario")
	public void AtualizarCliente(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosUsuarios")
	public List<Usuario> ListarTodosUsuarios();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorNome")
	public Usuario ListarPorNome(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCPF")
	public Usuario ListarPorCPF(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorCodigo")
	public Usuario pesquisarPorCodigo(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarUsuarioPorEmail")
	public Usuario pesquisarPorEmail(Usuario usuario);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/efetuarLogin")
	public Usuario efetuarLogin(Usuario usuario);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarSenhaUsuario")
	public boolean alteraSenha(Usuario usuario);
	// --------------------------------------------- Supermercado
	// -------------------------------------------------------------------

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarSupermercado")
	public void cadastrarSupermercado(Supermercado supermercado);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarSupermercado")
	public void atualizarSupermercado(Supermercado supermercado);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosSupermercados")
	public List<Supermercado> listarTodosSupermercados();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorCodigo")
	public Supermercado pesquisarPorCodigo(Supermercado supermercado);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarSupermercadoPorNome")
	public Supermercado listarPorNome(Supermercado supermercado);

	/*
	 * @GET
	 * @Produces("application/json; charset=UTF-8")
	 * @Consumes("application/json; charset=UTF-8")
	 * @Path("/pesquisarSupermercadoPorID") public Supermercado
	 * consultarPorID(Supermercado supermercado);
	 */
	// --------------------------------------------- Endereco
	// -------------------------------------------------------------------
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarEndereco")
	public void cadastrarEndereco(Endereco endereco);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarEndereco")
	public void atualizarEndereco(Endereco endereco);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosEnderecos")
	public List<Endereco> listarEndereco();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorCep")
	public Endereco listarPorCep(Endereco endereco);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarEnderecoPorLogradouro")
	public Endereco listarPorLogradouro(Endereco endereco);
	// --------------------------------------------- Lista de Compra
	// -------------------------------------------------------------------

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarLista")
	public void CadastrarLista(ListaDeCompras lista);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarLista")
	public void AtualizarLista(ListaDeCompras lista);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodasListas")
	public List<ListaDeCompras> ListarTodasAsListas();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarListaPorCodigo")
	public ListaDeCompras BuscarPorCodigo(ListaDeCompras lista);
	// --------------------------------------------- Perfil
	// -------------------------------------------------------------------

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPerfil")
	public void CadastrarPerfil(Perfil perfil);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPerfil")
	public void AtualizarPerfil(Perfil perfil);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosPerfis")
	public List<Perfil> ListarTodosPerfis();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPerfilPorCodigo")
	public Perfil PesquisarPorCodigo(Perfil perfil);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPerfilPorNome")
	public Perfil PesquisarPorNome(Perfil perfil);

	// --------------------------------------------- Produto
	// -------------------------------------------------------------------
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarProduto")
	public void CadastrarProduto(Produto produto);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarProduto")
	public void AtualizarProduto(Produto produto);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosProdutos")
	public List<Produto> ListarTodosProdutos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorNome")
	public Produto pesquisarProdutoPorNome(Produto produto);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarProdutoPorCodigo")
	public Produto pesquisarPorCodigo(Produto produto);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarProdutoPorSupermercado/{produto},{supermercado}")
	public List<Produto> listaProtudoDoSupermercado(@PathParam("produto") String nomeProduto,
			@PathParam("supermercado") String supermercado);

	// Método Duplicado
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarProdutoPorSupermercado")
	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado);

	// --------------------------------------------- Pagamento
	// -------------------------------------------------------------------
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPagamento")
	public void CadastrarPagamento(Pagamento pagamento);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPagamento")
	public void AtualizarPagamento(Pagamento pagamento);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosPagamentos")
	public List<Pagamento> ListarTodos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPagamentoPorCodigo")
	public Pagamento ListarPorCodigo(Pagamento pagamento);

	// --------------------------------------------- Item
	// -------------------------------------------------------------------
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarItem")
	public void CadastrarItem(Item item);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarItem")
	public void AtualizarItem(Item item);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosItens")
	public List<Item> ListarTodosItens();

	// --------------------------------------------- Pedido
	// -------------------------------------------------------------------
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrarPedido")
	public void CadastrarPedido(Pedido pedido);

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizarPedido")
	public void AlterarPedido(Pedido pedido);

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/listarTodosPedidos")
	public List<Pedido> ListarTodosPedidos();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/pesquisarPedidoPorCodigo")
	public Pedido ListarPedidoPorCodigo(Pedido pedido);
}