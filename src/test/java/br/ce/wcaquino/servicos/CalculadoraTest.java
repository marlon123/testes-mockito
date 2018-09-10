package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.exceptions.DivisaoPorZeroException;

public class CalculadoraTest {
	
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
