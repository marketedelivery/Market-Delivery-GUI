package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryPedido;
import br.com.marketedelivery.IDAO.IPedidoDAO;
import br.com.marketedelivery.classesBasicas.Pedido;

public class ControladorPedido
{
	private IPedidoDAO pedidoDAO;
	
	public void CadastrarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}
	
	public void AlterarPedido(Pedido pedido)
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}
	
	public List<Pedido>ListarTodosPedidos()
	{
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		return pedidoDAO.consultarTodos();
	}
	
	public Pedido ListarPedidoPorCodigo(Pedido pedido)
	{
		int codigo = pedido.getCodigo();
		pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		return pedidoDAO.consultarPorId(codigo);
	}
}
