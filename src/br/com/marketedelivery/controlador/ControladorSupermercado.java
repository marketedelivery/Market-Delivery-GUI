package br.com.marketedelivery.controlador;

import java.util.List;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.ISupermercadoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ControladorSupermercado
{
	private ISupermercadoDAO supermercadoDAO;

	public void cadastrarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		supermercadoDAO.inserir(supermercado);
		DAOFactory.close();
	}

	public void atualizarSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		DAOFactory.close();
	}

	public List<Supermercado> listarTodosSupermercados()
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		List<Supermercado> lista = supermercadoDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Supermercado pesquisarPorNome(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		String nome = supermercado.getNome();
		Supermercado retorno = supermercadoDAO.buscarPorNome(nome);
		DAOFactory.close();
		return retorno;
	}

	public Supermercado pesquisarPorCodigo(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado sup = supermercadoDAO.consultarPorId(supermercado.getCodigo());
		DAOFactory.close();
		return sup;
	}

	public List<Produto> listarProdutosDoSupermercado(String nomeProduto, String supermercado)
	{
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		return null;
	}

	public Supermercado consultarPorID(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		Supermercado s = supermercadoDAO.consultarPorId(supermercado.getCodigo());
		DAOFactory.close();
		return s;
	}

	/**
	 * 
	 * @return retorna MapModel
	 */
	public MapModel supermencadoProximo()
	{
		DAOFactory.abrir();
		// supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO = DAOFactory.getSupermercadoDAO();
		try
		{
			MapModel mapModel = new DefaultMapModel();
			List<Supermercado> lista = supermercadoDAO.consultarTodos();
			if (lista != null)
			{
				for (int i = 0; i < lista.size(); i++)
				{
					Double latitude = Double.parseDouble(lista.get(i).getLatitude());
					Double logitude = Double.parseDouble(lista.get(i).getLongitude());
					LatLng latLng = new LatLng(latitude, logitude);
					mapModel.addOverlay(new Marker(latLng, "Supermercado " + lista.get(i).getNome()));
					latLng = null;
				}
			}
			DAOFactory.close();
			return mapModel;
		}
		catch (Exception e)
		{
			e.getMessage();
			DAOFactory.close();
			return null;
		}
	}
}