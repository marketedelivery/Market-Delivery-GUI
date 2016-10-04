package br.com.marketedelivery.IFachada;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.Perfil;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.classesBasicas.Usuario;

public interface IFachada
{
	 public void CadastrarUsuario(Usuario usuario);
	 public void AtualizarCliente(Usuario usuario);
	 public List<Usuario>ListarTodosUsuarios();
	 public Usuario ListarPorNome(Usuario cliente);
	 public Usuario ListarPorCPF(Usuario cliente);
	 public Usuario pesquisarPorCodigo (Usuario cliente);
	 public Usuario pesquisarPorEmail(Usuario usuario);
	 
	 //--------------------------------------------- Supermercado -------------------------------------------------------------------
	 
	 public void cadastrarSupermercado(Supermercado supermercado);
	 public void atualizarSupermercado(Supermercado supermercado);
	 public List<Supermercado>listarSupermercado();
	 public Supermercado listarPorNome(Supermercado supermercado);
	 public List<Produto> listaProtudoDoSupermercado(String nomeProduto,String supermercado);
	 //--------------------------------------------- Endereco -------------------------------------------------------------------
	 
	 public void cadastrarEndereco(Endereco endereco);
	 public void atualizarEndereco(Endereco endereco);
	 public List<Endereco>listarEndereco();
	 public Endereco listarPorCep(Endereco endereco);
	 public Endereco listarPorLogradouro(Endereco endereco);
	 
	 //--------------------------------------------- Lista de Compra -------------------------------------------------------------------
	 
	 public void CadastrarLista(ListaDeCompras lista);
	 public void AtualizarLista(ListaDeCompras lista);
	 public List<ListaDeCompras>ListarTodasAsListas();
	 public ListaDeCompras BuscarPorCodigo(ListaDeCompras lista);
	 
	 //--------------------------------------------- Perfil -------------------------------------------------------------------
	
	 public void CadastrarPerfil(Perfil perfil);
	 public void AtualizarPerfil(Perfil perfil);
	 public List<Perfil>ListarTodosPerfil();
	 public Perfil PesquisarPorCodigo(Perfil perfil);
	 public Perfil PesquisarPorNome(Perfil perfil);
	 
	//--------------------------------------------- Produto -------------------------------------------------------------------
	 
		public void CadastrarProduto(Produto produto);
		public void AtualizarProduto(Produto produto);
		public List<Produto>ListarTodosProdutos();
		public Produto PesquisarProdutoPorNome(Produto produto);
		
		//--------------------------------------------- Pagamento -------------------------------------------------------------------
		
		public void CadastrarPagamento(Pagamento pagamento);
		public void AtualizarPAgamento(Pagamento pagamento);
		public List<Pagamento> ListarTodos();
		public Pagamento ListarPorCodigo(Pagamento pagamento);
		
		//--------------------------------------------- Item -------------------------------------------------------------------
		
		public void CadastrarItem(Item item);
		public void AtualizarItem(Item item);
		public List<Item> ListarTodosItem();
}
