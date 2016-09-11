/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.classesbasicas.Supermercado;

public class SupermercadoDao extends DAOGenerico<Supermercado> implements ISupermercadoDao{

    private EntityManager manager;

    public SupermercadoDao(EntityManager em) {
        super(em);
        this.manager = em;
    }

    public Supermercado buscarPorCNPJ(String cnpj) {
        String consulta = "SELECT c FROM Supermercado c WHERE c.cnpj = :N";
        TypedQuery<Supermercado> retorno = getEntityManager().createQuery(consulta, Supermercado.class);
        retorno.setParameter("N", cnpj);
        Supermercado resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;
        }
    }

    public Supermercado buscarPorNome(String nome) {
        String comandoSelect = "SELECT c FROM Supermercado c WHERE c.nome = :N ";
        TypedQuery<Supermercado> retorno = getEntityManager().createQuery(comandoSelect, Supermercado.class);
        retorno.setParameter("N", "%" + nome + "%");
        Supermercado resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

	
}
