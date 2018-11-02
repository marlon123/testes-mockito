package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.ce.wcaquino.exceptions.DivisaoPorZeroException;
import br.ce.wcaquino.runners.ParallelRunner;

@RunWith(ParallelRunner.class)
public class CalculadoraTest {
	
	public static StringBuffer ordem = new StringBuffer();
	private Calculadora calc;
	
	@Before
	public void setup(){
		calc = new Calculadora();
		System.out.println("iniciando...");
		ordem.append("1");
	}
	
	@After
	public void tearDown(){
		System.out.println("finalizando...");
	}
	
	@AfterClass
	public static void tearDownClass(){
		System.out.println(ordem.toString());
	}
	
	@Test
	public void deveSomarDoisValores() {
		//cenario
		int a = 5;
		int b = 3;
		Calculadora calc = new Calculadora();
		
		//ação
		int resultado = calc.soma(a, b);
		
		//verificação
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void deveSubtrairDoisValroes() {
		//cenario
		int a = 8;
		int b = 5;
		Calculadora calc = new Calculadora();
		
		//ação
		int resultado = calc.subtrai(a, b);
		
		//verificação
		Assert.assertEquals(3, resultado);
	}
	
	@Test
	public void deveDividirDoisValroes() throws DivisaoPorZeroException {
		//cenario
		int a = 8;
		int b = 4;
		Calculadora calc = new Calculadora();
		
		//ação
		double resultado = calc.divide(a, b);
		
		//verificação
		Assert.assertEquals(2, resultado, 0.01);
	}
	
	@Test(expected=DivisaoPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws DivisaoPorZeroException {
		//cenario
		int a = 8;
		int b = 0;
		Calculadora calc = new Calculadora();
		
		//ação
		double resultado = calc.divide(a, b);
		
		//verificação
		Assert.assertEquals(3, resultado, 0.01);
	}

}
