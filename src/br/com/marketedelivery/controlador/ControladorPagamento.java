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
		DAOFactory.abrir();
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.inserir(pagamento);
		DAOFactory.close();
	}

	public void atualizarPagamento(Pagamento pagamento)
	{
		DAOFactory.abrir();
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		pagamentoDAO.alterar(pagamento);
		DAOFactory.close();
	}

	public List<Pagamento> listarTodosPagamentos()
	{
		DAOFactory.abrir();
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		List<Pagamento> lista = pagamentoDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Pagamento listarPorCodigo(Pagamento pagamento)
	{
		DAOFactory.abrir();
		int codigo = pagamento.getCodigo();
		// pagamentoDAO = DAOFactoryPagamento.getPagamentoDAO();
		pagamentoDAO = DAOFactory.getPagamentoDAO();
		Pagamento retorno = pagamentoDAO.consultarPorId(codigo);
		DAOFactory.close();
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
