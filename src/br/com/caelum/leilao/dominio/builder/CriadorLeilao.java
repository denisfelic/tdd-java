package br.com.caelum.leilao.dominio.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class CriadorLeilao {

	private Leilao leilao;

	public CriadorLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorLeilao lance(Usuario usuario, double valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return this.leilao;
	}

}
