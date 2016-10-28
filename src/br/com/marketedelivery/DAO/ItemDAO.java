package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;

import br.com.marketedelivery.IDAO.IItemDAO;
import br.com.marketedelivery.classesBasicas.Item;

public class ItemDAO extends DAOGenerico<Item>implements IItemDAO
{

	public ItemDAO(EntityManager em) {
		super(em);
	}

}
