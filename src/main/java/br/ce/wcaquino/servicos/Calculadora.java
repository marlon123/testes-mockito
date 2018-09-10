package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.DivisaoPorZeroException;

public class Calculadora {

	public int soma(int a, int b) {
		return a+b;
	}

	public int subtrai(int a, int b) {
		return a-b;
	}

	public double divide(int a, int b) throws DivisaoPorZeroException {
		if(b == 0)
			throw new DivisaoPorZeroException();
		
		return a/b;
	}

}
