package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IPagamentoDAO;
import br.com.marketedelivery.classesBasicas.Pagamento;

public class ControladorPagamento
{
	private IPagamentoDAO pagamentoDAO;

	public void cadastrarPagamento(Pagamento pagamento)
	{
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.inserir(pagamento);
	}

	public void atualizarPagamento(Pagamento pagamento)
	{
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.alterar(pagamento);
	}

	public List<Pagamento> listarTodosPagamentos()
	{
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		List<Pagamento> lista = pagamentoDAO.consultarTodos();
		return lista;
	}

	public Pagamento listarPorCodigo(Pagamento pagamento)
	{
		int codigo = pagamento.getCodigo();
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento retorno = pagamentoDAO.consultarPorId(codigo);
		return retorno;
	}

	public Pagamento buscarPorStatus(Pagamento pagamento)
	{
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		// Pagamento retorno =
		// pagamentoDAO.buscarPorStatus(pagamento.getStatus());
		// return retorno;]
		return null;
	}
}
