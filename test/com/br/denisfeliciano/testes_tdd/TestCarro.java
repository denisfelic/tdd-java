package com.br.denisfeliciano.testes_tdd;

import com.br.denisfeliciano.Carro;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;

public class TestCarro {
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	

    @Test
    public void deveRetornarNumeroCarroIgualA124() {

        // scenery
        Carro carro = new Carro();
        // action
        int numeroDoCarro = carro.getNumero();
        // validation
        assertEquals(124, numeroDoCarro);
    }
    
    @Test
    public void TESTE() {

        assertEquals(true, true);
    }
}
