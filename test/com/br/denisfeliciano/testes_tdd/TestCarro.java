package com.br.denisfeliciano.testes_tdd;

import com.br.denisfeliciano.Carro;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCarro {

    @Test
    public void deveRetornarNumeroCarroIgualA24() {

        // cenário
        Carro carro = new Carro();
        // ação
        int numeroDoCarro = carro.getNumero();
        // validação
        assertEquals(124, numeroDoCarro);
    }
}
