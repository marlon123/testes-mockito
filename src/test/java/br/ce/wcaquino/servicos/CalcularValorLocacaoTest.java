package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalcularValorLocacaoTest {
	
	@InjectMocks
	private LocacaoService service;
	
	@Mock
	LocacaoDAO locacaoDAO;
	
	@Mock
	SPCService spc;
	
	@Parameter(value=0)
	public Usuario usuario;
	
	@Parameter(value=1)
	public List<Filme> filmes;
	
	@Parameter(value=2)
	public Double valorLocacao;
	
	@Parameter(value=3)
	public String cenario;
	
	private static Filme filme1 = umFilme().agora();
	private static Filme filme2 = umFilme().agora();
	private static Filme filme3 = umFilme().agora();
	private static Filme filme4 = umFilme().agora();
	private static Filme filme5 = umFilme().agora();
	private static Filme filme6 = umFilme().agora();
	private static Filme filme7 = umFilme().agora();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Parameters(name="{3}")
	public static Collection<Object[]> getParametros(){
		return Arrays.asList(new Object[][] {
			{new Usuario("Marlon"), Arrays.asList(filme1, filme2), 8.0, "2 Filmes: Sem desconto"},
			{new Usuario("Joao"), Arrays.asList(filme1, filme2, filme3), 11.0, "3 Filmes: 25%"},
			{new Usuario("Jose"), Arrays.asList(filme1, filme2, filme3, filme4), 13.0, "4 Filmes: 50%"},
			{new Usuario("Lucas"), Arrays.asList(filme1, filme2, filme3, filme4, filme5), 14.0, "5 Filmes: 75%"},
			{new Usuario("Maria"), Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 14.0, "6 Filmes: 100%"},
			{new Usuario("Marcos"), Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6, filme7), 18.0, "7 Filmes: Sem desconto"}
		});
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		//Usuario usuario = new Usuario("Marlon");
		
		//ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		//verificação
		Assert.assertThat(locacao.getValor(), CoreMatchers.is(valorLocacao));
	}

}
