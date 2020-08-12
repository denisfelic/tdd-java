package com.br.denisfeliciano.testes_tdd;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.dominio.builder.CriadorLeilao;
import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

public class TestLeilao {

	private Avaliador leioleiro;
	private Usuario denis;
	private Usuario jade;
	private Usuario kelvyn;
	private Usuario du;
	private Usuario lucas;

	@Before
	// Test data Builders
	public void criarAvaliador() {
		// Executa antes do Teste (before)
		this.leioleiro = new Avaliador();
		denis = new Usuario("Denis");
		jade = new Usuario("Jade");
		kelvyn = new Usuario("Kelvyn");
		du = new Usuario("Du");
		lucas = new Usuario("Lucas");
	}

	@After
	public void finaliza() {
		System.out.println("Teste ocorrido com sucesso! :-) ");
	}

	@Test
	public void dadoLancesEmOrdemCrescenteDeveRetornarMaiorValor() {
		// c

		Leilao leilao = new CriadorLeilao().para("PlayStation 3 Usado").lance(denis, 200.0).lance(jade, 400.0)
				.lance(kelvyn, 600.0).constroi();

		// a
		leioleiro.avalia(leilao.getLances());

		// v
		assertEquals(3, leilao.getLances().size());
		assertEquals(600, leioleiro.getMaiorDeTodos().getValor(), 0.00001);

	}

	@Test
	public void deveRetornarUmaListaComTresMaioresLancesOrdenados() {

		Leilao leilao = new CriadorLeilao().para("Ps3 Usado").lance(kelvyn, 50.0).lance(jade, 150.0).lance(denis, 250.0)
				.lance(lucas, 300.0).lance(du, 400.0).lance(jade, 500.0).constroi();
		// a
		this.leioleiro.avalia(leilao.getLances());

		// v
		assertEquals(3, this.leioleiro.getTresMaioresLances().size());
		assertEquals(500, this.leioleiro.getTresMaioresLances().get(0).getValor(), 0.00001);
		assertEquals(400, this.leioleiro.getTresMaioresLances().get(1).getValor(), 0.00001);
		assertEquals(300, this.leioleiro.getTresMaioresLances().get(2).getValor(), 0.00001);

	}

	@Test
	public void deveRetornarUmaListaComTresMenoresLancesOrdenados() {
		Lance lance1 = new Lance(new Usuario("User2"), 50);
		Lance lance2 = new Lance(new Usuario("User1"), 150);
		Lance lance3 = new Lance(new Usuario("User1"), 250);
		Lance lance4 = new Lance(new Usuario("User3"), 300);
		Lance lance5 = new Lance(new Usuario("User1"), 400);
		Lance lance6 = new Lance(new Usuario("User1"), 800);

		Leilao leilao = new Leilao("Ps3 usado");
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.propoe(lance4);
		leilao.propoe(lance5);
		leilao.propoe(lance6);
		// a
		this.leioleiro.avalia(leilao.getLances());

		// v.
		assertEquals(3, this.leioleiro.getTresMenoresLances().size());
		assertEquals(50, this.leioleiro.getTresMenoresLances().get(0).getValor(), 0.00001);
		assertEquals(150, this.leioleiro.getTresMenoresLances().get(1).getValor(), 0.00001);
		assertEquals(250, this.leioleiro.getTresMenoresLances().get(2).getValor(), 0.00001);

	}

	@Test
	public void deveRetornarNomeDeUsuarioIgualAoSetado() {

		Lance lance1 = new Lance(new Usuario("Iris"), 50);
		Lance lance2 = new Lance(new Usuario("User1"), 150);
		Lance lance3 = new Lance(new Usuario("User1"), 250);
		Lance lance4 = new Lance(new Usuario("User3"), 300);
		Lance lance5 = new Lance(new Usuario("User1"), 400);
		Lance lance6 = new Lance(new Usuario("User1"), 800);

		Leilao leilao = new Leilao("Ps3 usado");
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.propoe(lance4);
		leilao.propoe(lance5);
		leilao.propoe(lance6);
		// a
		this.leioleiro.avalia(leilao.getLances());
		this.leioleiro.getTresMenoresLances().get(0).getUsuario().setNome("Marcos");

		// v
		assertEquals(3, this.leioleiro.getTresMaioresLances().size());
		assertEquals(50, this.leioleiro.getTresMenoresLances().get(0).getValor(), 0.00001);
		assertEquals(50, lance1.getValor(), 0.00001);
		assertEquals("Marcos", lance1.getUsuario().getNome());

	}

	@Test
	public void deveEntenderUmaListaQueRetornaUmUnicoLance() {

		Lance lance1 = new Lance(new Usuario("Marcos"), 300);
		Leilao leilao = new Leilao("Ps3 usado");
		leilao.propoe(lance1);

		this.leioleiro.avalia(leilao.getLances());

		// v
		assertEquals(1, this.leioleiro.getTresMaioresLances().size());
		assertEquals(300, this.leioleiro.getTresMenoresLances().get(0).getValor(), 0.00001);
		assertEquals(300, this.leioleiro.getTresMaioresLances().get(0).getValor(), 0.00001);

	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		// c a v
		Lance lance1 = new Lance(new Usuario("Wozniak"), 2000.0);

		Leilao leilao = new Leilao("PS4");
		leilao.propoe(lance1);
		leilao.propoe(lance1);

		this.leioleiro.avalia(leilao.getLances());

		assertEquals(1, this.leioleiro.getTresMaioresLances().size());
		assertEquals(2000.0, this.leioleiro.getTresMaioresLances().get(0).getValor(), 0.00001);

	}

	@Test
	public void naoDeveAceitarMaisQueCincoLancesDeUmMesmoUsuario() {
		Usuario steveWoz = new Usuario("Woz");
		Usuario steveJobs = new Usuario("Jobs");

		Lance lance1 = new Lance(steveWoz, 1000.0);
		Lance lance2 = new Lance(steveJobs, 1200.0);

		Lance lance3 = new Lance(steveWoz, 1500.0);
		Lance lance4 = new Lance(steveJobs, 2000.0);

		Lance lance5 = new Lance(steveWoz, 2500.0);
		Lance lance6 = new Lance(steveJobs, 3000.0);

		Lance lance7 = new Lance(steveWoz, 3500.0);
		Lance lance8 = new Lance(steveJobs, 4000.0);

		Lance lance9 = new Lance(steveWoz, 5000.0);
		Lance lance10 = new Lance(steveJobs, 5500.0);

		Lance lance11 = new Lance(steveWoz, 6000.0);

		Leilao leilao = new Leilao("PS5");
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.propoe(lance4);
		leilao.propoe(lance5);
		leilao.propoe(lance6);
		leilao.propoe(lance7);
		leilao.propoe(lance8);
		leilao.propoe(lance9);
		leilao.propoe(lance10);
		leilao.propoe(lance11);

		this.leioleiro.avalia(leilao.getLances());

		assertEquals(10, leilao.getLances().size());
		assertEquals(5500, this.leioleiro.getMaiorDeTodos().getValor(), 0.00001);
		assertEquals(5000, this.leioleiro.getTresMaioresLances().get(1).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarValoresMenoresOuIguaisAoDoLanceAnterior() {
		Usuario steveWoz = new Usuario("Woz");
		Usuario steveJobs = new Usuario("Jobs");

		Lance lance1 = new Lance(steveWoz, 1000.0);
		Lance lance2 = new Lance(steveJobs, 1200.0);

		Lance lance3 = new Lance(steveWoz, 1500.0);
		Lance lance4 = new Lance(steveJobs, 2000.0);

		Lance lance5 = new Lance(steveWoz, 5000.0);
		Lance lance6 = new Lance(steveJobs, 5500.0);

		Lance lance7 = new Lance(steveWoz, 5500.0);

		Leilao leilao = new Leilao("PS5");
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.propoe(lance4);
		leilao.propoe(lance5);
		leilao.propoe(lance6);
		leilao.propoe(lance7);

		this.leioleiro.avalia(leilao.getLances());

		assertEquals(6, leilao.getLances().size());
		assertEquals(5500, this.leioleiro.getTresMaioresLances().get(0).getValor(), 0.00001);
		assertEquals(5000, this.leioleiro.getTresMaioresLances().get(1).getValor(), 0.00001);
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {

		Leilao leilao = new CriadorLeilao().para("PS4").constroi();
		criarAvaliador();

		this.leioleiro.avalia(leilao.getLances());

	}

}
