package br.ce.wcaquino.servicos;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;
	
	@Spy
	private Calculadora calcSpy;
	
	@Mock
	private EmailService emailService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveMostrarDiferencaEntreMockSpy() {
		when(calcMock.soma(1, 2)).thenCallRealMethod();
//		when(calcSpy.soma(1, 2)).thenReturn(8);
		doReturn(5).when(calcSpy).soma(1, 2);
		doNothing().when(calcSpy).imprime();
		
		System.out.println("Mock: " + calcMock.soma(1, 2)) ;
		System.out.println("Spy: " + calcSpy.soma(1, 2)) ;
		
		System.out.println("Mock");
		calcMock.imprime();
		System.out.println("Spy");
		calcSpy.imprime();
	}
	
	@Test
	public void teste() {
		Calculadora calc = mock(Calculadora.class);
		
		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		when(calc.soma(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, calc.soma(1, 4));
		System.out.println(argCapt.getAllValues());
	}

}
