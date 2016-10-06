package br.com.marketedelivery.Fachada;

import java.util.List;

import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Pagamento;
import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.classesBasicas.Perfil;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.classesBasicas.Usuario;
import br.com.marketedelivery.controlador.ControladorEndereco;
import br.com.marketedelivery.controlador.ControladorItem;
import br.com.marketedelivery.controlador.ControladorListadeCompra;
import br.com.marketedelivery.controlador.ControladorPagamento;
import br.com.marketedelivery.controlador.ControladorPedido;
import br.com.marketedelivery.controlador.ControladorPerfil;
import br.com.marketedelivery.controlador.ControladorProduto;
import br.com.marketedelivery.controlador.ControladorSupermercado;
import br.com.marketedelivery.controlador.ControladorUsuario;

public class Fachada implements IFachada
{
	private IFachada instancia;
	
	private ControladorEndereco conEndereco;
	private ControladorSupermercado conSupermercado;
	private ControladorUsuario conUsuario;
	private ControladorListadeCompra conLista;
	private ControladorPagamento conPagamento;
	private ControladorPerfil conPerfil;
	private ControladorProduto conProduto;
	private ControladorItem conItem;
	private ControladorPedido conPedido;
	
	 public  IFachada getInstancia()
	    {
	        if (instancia == null)
	        {
	            instancia = new Fachada();
	        }
	        return instancia;
	    }
	 
	 public Fachada()
	 {
		 conEndereco = new ControladorEndereco();
		 conSupermercado = new ControladorSupermercado();
		 conUsuario = new ControladorUsuario();
		 conLista = new ControladorListadeCompra();
		 conPagamento = new ControladorPagamento();
		 conPerfil = new ControladorPerfil();
		 conProduto = new ControladorProduto();
		 conItem = new ControladorItem();
		 conPedido = new ControladorPedido();
	 }
	 
	 public void CadastrarUsuario(Usuario usuario)
	 {
		 conUsuario.CadastrarUsuario(usuario);
	 }
	 
	 public void AtualizarCliente(Usuario usuario)
	 {
		 conUsuario.atualizarUsuario(usuario);
	 }
	 
	 public List<Usuario>ListarTodosUsuarios()
	 {
		 return conUsuario.ListarTodosUsuarios();
	 }
	 
	 public Usuario ListarPorNome(Usuario usuario)
	 {
		 return conUsuario.ListarPorNome(usuario);
	 }
	 
	 public Usuario ListarPorCPF(Usuario usuario)
	 {
		 return conUsuario.ListarPorCPF(usuario);
	 }
		 
	 @Override
	public Usuario pesquisarPorCodigo(Usuario usuario)
	 {
		// TODO Auto-generated method stub
			return conUsuario.pesquisarUsuarioPorCodigo(usuario);
	 }
	 
	 public Usuario pesquisarPorEmail(Usuario usuario)
	 {
		 return conUsuario.pesquisarPorEmail(usuario);
	 }
	 
	 //--------------------------------------------- Supermercado -------------------------------------------------------------------
	 
	 public void cadastrarSupermercado(Supermercado supermercado)
	 {
		 conSupermercado.cadastrarSupermercado(supermercado);
	 }
	 
	 public void atualizarSupermercado(Supermercado supermercado)
	 {
		 conSupermercado.atualizarSupermercado(supermercado);
	 }
	 
	 public List<Supermercado>listarSupermercado()
	 {
		 return conSupermercado.listarTodosSupermercados();
	 }
	 
	 public Supermercado listarPorNome(Supermercado supermercado)
	 {
		 return conSupermercado.pesquisarPorNome(supermercado);
	 }
	 
	 @Override
		public List<Produto> listaProtudoDoSupermercado(String nomeProduto, String supermercado) {
			// TODO Auto-generated method stub
			return null;
		}
	 

	 //--------------------------------------------- Endereco -------------------------------------------------------------------
	 
	 public void cadastrarEndereco(Endereco endereco)
	 {
		 conEndereco.cadastrarEndereco(endereco);
	 }
	 
	 public void atualizarEndereco(Endereco endereco)
	 {
		 conEndereco.atualizarEndereco(endereco);
	 }
	 
	 public List<Endereco>listarEndereco()
	 {
		 return conEndereco.listarTodosEndereco();
	 }
	
	 public Endereco listarPorCep(Endereco endereco)
	 {
		 return conEndereco.pesquisarPorCep(endereco);
	 }
	 
	 public Endereco listarPorLogradouro(Endereco endereco)
	 {
		 return conEndereco.pesquisarPorLogradouro(endereco);
	 }
	 
	 //--------------------------------------------- Lista de Compra -------------------------------------------------------------------
	 
	 public void CadastrarLista(ListaDeCompras lista)
	 {
		 conLista.CadastrarLista(lista);
	 }
	 
	 public void AtualizarLista(ListaDeCompras lista)
	 {
		 conLista.AtualizarLista(lista);
	 }
	 
	 public List<ListaDeCompras>ListarTodasAsListas()
	 {
		 return conLista.ListarTudo();
	 }
	 
	 public ListaDeCompras BuscarPorCodigo(ListaDeCompras lista)
	 {
		 return conLista.buscarPorCodigo(lista);
	 }
	 
	 //--------------------------------------------- Perfil -------------------------------------------------------------------
	
	 public void CadastrarPerfil(Perfil perfil)
	 {
		 conPerfil.CadastrarPerfil(perfil);
	 }
	 
	 public void AtualizarPerfil(Perfil perfil)
	 {
		 conPerfil.AtualizarPerfil(perfil);
	 }
	 
	 public List<Perfil>ListarTodosPerfil()
	 {
		 return conPerfil.ListarTodosPerfil();
	 }
	 
	 public Perfil PesquisarPorCodigo(Perfil perfil)
	 {
		 return conPerfil.PesquisarPorCodigo(perfil);
	 }
	 
	 public Perfil PesquisarPorNome(Perfil perfil)
	 {
		 return conPerfil.PesquisarPorNome(perfil);
	 }
	 
	//--------------------------------------------- Produto -------------------------------------------------------------------
	 
		public void CadastrarProduto(Produto produto)
		{
			conProduto.CadastrarProduto(produto);
		}
		
		public void AtualizarProduto(Produto produto)
		{
			conProduto.AtualizarProduto(produto);
		}
		
		public List<Produto>ListarTodosProdutos()
		{
			return conProduto.ListarTodosProdutos();
		}
		
		public Produto PesquisarProdutoPorNome(Produto produto)
		{
			return conProduto.PesquisarProdutoPorNome(produto);
		}
		
		//--------------------------------------------- Pagamento -------------------------------------------------------------------
		
		public void CadastrarPagamento(Pagamento pagamento)
		{
			conPagamento.CadastrarPagamento(pagamento);
		}
		
		public void AtualizarPAgamento(Pagamento pagamento)
		{
			conPagamento.AtualizarPAgamento(pagamento);
		}
		
		public List<Pagamento> ListarTodos()
		{
			return conPagamento.ListarTodos();
		}
		
		public Pagamento ListarPorCodigo(Pagamento pagamento)
		{
			return conPagamento.ListarPorCodigo(pagamento);
		}
		
		//--------------------------------------------- Item -------------------------------------------------------------------
		
		public void CadastrarItem(Item item)
		{
			conItem.CadastrarItem(item);
		}
		
		public void AtualizarItem(Item item)
		{
			conItem.AtualizarItem(item);
		}
		
		public List<Item> ListarTodosItem()
		{
			return conItem.ListarTodosItem();
		}
		
		//--------------------------------------------- Pedido -------------------------------------------------------------------
		
		public void CadastrarPedido(Pedido pedido)
		{
			conPedido.CadastrarPedido(pedido);
		}
		
		public void AlterarPedido(Pedido pedido)
		{
			conPedido.AlterarPedido(pedido);
		}
		
		public List<Pedido>ListarTodosPedidos()
		{
			return conPedido.ListarTodosPedidos();
		}
		
		public Pedido ListarPedidoPorCodigo(Pedido pedido)
		{
			return conPedido.ListarPedidoPorCodigo(pedido);
		}
		
		public List<Supermercado> listarProdutoPorSupermercado(Supermercado supermercado)
		{
			return conSupermercado.listarProdutoPorSupermercado(supermercado);
		}

		@Override
		public Produto pesquisarProdutoPorNome(Produto produto) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Produto pesquisarPorCodigo(Produto produto) {
			// TODO Auto-generated method stub
			return null;
		}

		

		
}
