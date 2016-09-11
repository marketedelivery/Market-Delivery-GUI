package br.com.marketedelivery.managedBean;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.view.ViewScoped;

import br.com.marketedelivery.camada.dados.FacesUtil;
import br.com.marketedelivery.camada.dados.SupermercadoDao;
import br.com.marketedelivery.classesbasicas.Supermercado;

@ManagedBean
@ViewScoped
public class SupermercadoBean {

	private Supermercado supermercadoCadastro;

	public void salvar() {
		// FacesUtil.adicionarMsgInfo(supermercadoCadastro.toString());
		try {
			SupermercadoDao supermercadoDao = new SupermercadoDao(null);
			supermercadoDao.inserir(supermercadoCadastro);

			supermercadoCadastro = new Supermercado();

			FacesUtil.adicionarMsgInfo("Supermercado salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao adicionar o registro:" + ex.getMessage());
		}

	}

	public Supermercado getSupermercadoCadastro() {
		if (supermercadoCadastro == null) {
			supermercadoCadastro = new Supermercado();
		}
		return supermercadoCadastro;
	}

	public void setSupermercadoCadastro(Supermercado supermercadoCadastro) {
		this.supermercadoCadastro = supermercadoCadastro;
	}
}
