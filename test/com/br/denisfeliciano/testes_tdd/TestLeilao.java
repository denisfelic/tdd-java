package com.br.denisfeliciano.testes_tdd;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLeilao {

    @Test
    public void dadoLancesEmOrdemCrescenteDeveRetornarMaiorValor() {
        // c

        Lance lance1 = new Lance(new Usuario("User1"), 400);
        Lance lance2 = new Lance(new Usuario("User2"), 500);
        Lance lance3 = new Lance(new Usuario("User3"), 600);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(3, leilao.getLances().size());
        assertEquals(600, avaliadorDeLeiloes.getMaiorDeTodos().getValor(), 0.00001);

    }

    @Test
    public void dadoLancesEmOrdemDecrescenteDeveRetornarMaiorValor() {
        // c

        Lance lance3 = new Lance(new Usuario("User3"), 600);
        Lance lance2 = new Lance(new Usuario("User2"), 500);
        Lance lance1 = new Lance(new Usuario("User1"), 400);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(3, leilao.getLances().size());
        assertEquals(600, avaliadorDeLeiloes.getMaiorDeTodos().getValor(), 0.00001);

    }

    @Test
    public void dadoLancesAleatoriosDeveRetornarMaiorValor() {
        // c

        Lance lance1 = new Lance(new Usuario("User3"), 300);
        Lance lance2 = new Lance(new Usuario("User2"), 50);
        Lance lance3 = new Lance(new Usuario("User1"), 400);
        Lance lance4 = new Lance(new Usuario("User1"), 250);
        Lance lance5 = new Lance(new Usuario("User1"), 150);
        Lance lance6 = new Lance(new Usuario("User1"), 800);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(6, leilao.getLances().size());
        assertEquals(800, avaliadorDeLeiloes.getMaiorDeTodos().getValor(), 0.00001);

    }

    @Test
    public void dadoLancesEmOrdemCrescenteDeveRetornarMenorDeTodos() {
        // c a v
        Lance lance1 = new Lance(new Usuario("José"), 200);
        Lance lance2 = new Lance(new Usuario("Inacio"), 400);
        Lance lance3 = new Lance(new Usuario("Marco"), 700);

        Leilao leilao = new Leilao("Ps3 em bom estado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao.getLances());

        assertEquals(3, leilao.getLances().size());
        assertEquals(200, avaliador.getMenorDeTodos().getValor(), 0.00001);
    }

    @Test
    public void dadoLancesEmOrdemDecrescenteDeveRetornarMenorDeTodos() {
        // c a v
        Lance lance3 = new Lance(new Usuario("Marco"), 700);
        Lance lance2 = new Lance(new Usuario("Inacio"), 400);
        Lance lance1 = new Lance(new Usuario("José"), 200);

        Leilao leilao = new Leilao("Ps3 em bom estado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao.getLances());

        assertEquals(3, leilao.getLances().size());
        assertEquals(200, avaliador.getMenorDeTodos().getValor(), 0.00001);
    }

    @Test
    public void dadoLancesAleatoriosDeveRetornarMenorValor() {
        // c

        Lance lance1 = new Lance(new Usuario("User3"), 300);
        Lance lance2 = new Lance(new Usuario("User2"), 50);
        Lance lance3 = new Lance(new Usuario("User1"), 400);
        Lance lance4 = new Lance(new Usuario("User1"), 250);
        Lance lance5 = new Lance(new Usuario("User1"), 150);
        Lance lance6 = new Lance(new Usuario("User1"), 800);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(6, leilao.getLances().size());
        assertEquals(50, avaliadorDeLeiloes.getMenorDeTodos().getValor(), 0.00001);

    }

    @Test
    public void deveRetornarUmaListaComTresMaioresLancesOrdenados(){
        Lance lance1 = new Lance(new Usuario("User3"), 300);
        Lance lance2 = new Lance(new Usuario("User2"), 50);
        Lance lance3 = new Lance(new Usuario("User1"), 400);
        Lance lance4 = new Lance(new Usuario("User1"), 250);
        Lance lance5 = new Lance(new Usuario("User1"), 150);
        Lance lance6 = new Lance(new Usuario("User1"), 800);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(3, avaliadorDeLeiloes.getTresMaioresLances().size());
        assertEquals(800, avaliadorDeLeiloes.getTresMaioresLances().get(0).getValor(), 0.00001);
        assertEquals(400, avaliadorDeLeiloes.getTresMaioresLances().get(1).getValor(), 0.00001);
        assertEquals(300, avaliadorDeLeiloes.getTresMaioresLances().get(2).getValor(), 0.00001);


    }


    @Test
    public void deveRetornarUmaListaComTresMenoresLancesOrdenados(){
        Lance lance1 = new Lance(new Usuario("User3"), 300);
        Lance lance2 = new Lance(new Usuario("User2"), 50);
        Lance lance3 = new Lance(new Usuario("User1"), 400);
        Lance lance4 = new Lance(new Usuario("User1"), 250);
        Lance lance5 = new Lance(new Usuario("User1"), 150);
        Lance lance6 = new Lance(new Usuario("User1"), 800);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v.
        assertEquals(3, avaliadorDeLeiloes.getTresMenoresLances().size());
        assertEquals(50, avaliadorDeLeiloes.getTresMenoresLances().get(0).getValor(), 0.00001);
        assertEquals(150, avaliadorDeLeiloes.getTresMenoresLances().get(1).getValor(), 0.00001);
        assertEquals(250, avaliadorDeLeiloes.getTresMenoresLances().get(2).getValor(), 0.00001);


    }


    @Test
    public void deveRetornarNomeDeUsuarioIgualAoSetado(){

        Lance lance1 = new Lance(new Usuario("User3"), 300);
        Lance lance2 = new Lance(new Usuario("Iris"), 50);
        Lance lance3 = new Lance(new Usuario("User1"), 400);
        Lance lance4 = new Lance(new Usuario("User1"), 250);
        Lance lance5 = new Lance(new Usuario("User1"), 150);
        Lance lance6 = new Lance(new Usuario("User1"), 800);

        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);
        // a
        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());
        avaliadorDeLeiloes.getTresMenoresLances().get(0).getUsuario().setNome("Marcos");

        // v
        assertEquals(3, avaliadorDeLeiloes.getTresMaioresLances().size());
        assertEquals(50, avaliadorDeLeiloes.getTresMenoresLances().get(0).getValor(), 0.00001);
        assertEquals(50, lance2.getValor(), 0.00001);
        assertEquals("Marcos", lance2.getUsuario().getNome());

    }

    @Test
    public void deveEntenderUmaListaQueRetornaUmUnicoLance(){

        Lance lance1 = new Lance(new Usuario("Marcos"), 300);
        Leilao leilao = new Leilao("Ps3 usado");
        leilao.propoe(lance1);

        Avaliador avaliadorDeLeiloes = new Avaliador();
        avaliadorDeLeiloes.avalia(leilao.getLances());

        // v
        assertEquals(1, avaliadorDeLeiloes.getTresMaioresLances().size());
        assertEquals(300, avaliadorDeLeiloes.getTresMenoresLances().get(0).getValor(), 0.00001);
        assertEquals(300, avaliadorDeLeiloes.getTresMaioresLances().get(0).getValor(), 0.00001);

    }


}
