package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IPedidoDAO;
import br.com.marketedelivery.classesBasicas.Pedido;

public class ControladorPedido
{
	private IPedidoDAO pedidoDAO;

	public void cadastrarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
		DAOFactory.close();
	}

	public void atualizarPedido(Pedido pedido)
	{
		DAOFactory.abrir();
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.alterar(pedido);
		DAOFactory.close();
	}

	public List<Pedido> listarTodosPedidos()
	{
		DAOFactory.abrir();
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		List<Pedido> lista = pedidoDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Pedido listarPedidoPorCodigo(Pedido pedido)
	{
		DAOFactory.abrir();
		int codigo = pedido.getCodigo();
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		Pedido p = pedidoDAO.consultarPorId(codigo);
		DAOFactory.close();
		return p;
	}
}