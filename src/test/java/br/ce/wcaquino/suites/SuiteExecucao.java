package br.ce.wcaquino.suites;

import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.servicos.CalcularValorLocacaoTest;
import br.ce.wcaquino.servicos.LocacaoServiceTest;

//@RunWith(Suite.class)
@SuiteClasses({
	//CalculadoraTest.class,
	CalcularValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {

}
