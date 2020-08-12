package com.br.denisfeliciano.testes_tdd;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class TestLance {

	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLancesComValoresMenoresZero() {
		Lance l1 = new Lance(new Usuario("Denis"), -14.0);
 	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLancesComValoresIguaisAZero() {
		Lance l1 = new Lance(new Usuario("Denis"), 0);
 	}
}
