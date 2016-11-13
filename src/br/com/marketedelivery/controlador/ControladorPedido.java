package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.DAOFactory.DAOFactoryPedido;
import br.com.marketedelivery.IDAO.IPedidoDAO;
import br.com.marketedelivery.classesBasicas.Pedido;

public class ControladorPedido {
	private IPedidoDAO pedidoDAO;

	public void cadastrarPedido(Pedido pedido) {
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}

	public void atualizarPedido(Pedido pedido) {
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		pedidoDAO.inserir(pedido);
	}

	public List<Pedido> listarTodosPedidos() {
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		return pedidoDAO.consultarTodos();
	}

	public Pedido listarPedidoPorCodigo(Pedido pedido) {
		int codigo = pedido.getCodigo();
		// pedidoDAO = DAOFactoryPedido.getPedidoDAO();
		pedidoDAO = DAOFactory.getPedidoDAO();
		return pedidoDAO.consultarPorId(codigo);
	}
}
