package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Cliente;


public class ClienteDao extends DAOGenerico<Cliente> implements IClienteDao
{
	private EntityManager manager;
	
	public ClienteDao(EntityManager em) 
	{
		super(em);
		this.manager = em;
		// TODO Auto-generated constructor stub
	}
	
	public Cliente buscarClientePorCPF(String cpf_cnpj)
    {
        String consulta = "SELECT c FROM Cliente c WHERE c.cpf_cnpj = :N";
        TypedQuery<Cliente> retorno = getEntityManager().createQuery(consulta, Cliente.class);
        retorno.setParameter("N", cpf_cnpj);
        Cliente resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
}
