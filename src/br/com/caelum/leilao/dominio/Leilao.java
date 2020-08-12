package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private int MAX_LANCES_POR_USUARIO = 5;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	// não pode dois lances seguidos do mesmo usuario
	public void propoe(Lance lance) {
 		if (lances.isEmpty() || usuarioPodeDarLance(lance))
			lances.add(lance);
	}

	/**
	 * @param lanceAtual
 	 * @return
	 */
	private boolean usuarioPodeDarLance(Lance lanceAtual) {
		int qtdLancesUsuario = getQuantidadeLancesUsuario(lanceAtual);
		return usuarioNaoExcedeuMaxLances(qtdLancesUsuario) && usuarioDoUltimoLanceDiferenteDe(lanceAtual) && lanceAnteriorMenorQue(lanceAtual);
	}

	/**
	 * @param lance
	 * @return
	 */
	private boolean lanceAnteriorMenorQue(Lance lance) {
		return lance.getValor() > getUtimoLance().getValor();
	}

	/**
	 * @param lance
	 * @return
	 */
	private boolean usuarioDoUltimoLanceDiferenteDe(Lance lance) {
		return getUtimoLance().getUsuario() != lance.getUsuario();
	}

	/**
	 * @param qtdLancesUsuario
	 * @return
	 */
	private boolean usuarioNaoExcedeuMaxLances(int qtdLancesUsuario) {
		return qtdLancesUsuario < MAX_LANCES_POR_USUARIO;
	}

	private int getQuantidadeLancesUsuario(Lance lance) {
		int qtdLancesUsuario = 0;
		for (Lance l : lances) {
			if (l.getUsuario() == lance.getUsuario())
				qtdLancesUsuario++;
		}
		return qtdLancesUsuario;
	}

	private Lance getUtimoLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
