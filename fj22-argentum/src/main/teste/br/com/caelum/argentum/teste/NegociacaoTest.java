package br.com.caelum.argentum.teste;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;


import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoTest {

	@Test
	public void data_da_negociacao_eh_imutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nao_cria_negociacao_com_data_nula() {
		new Negociacao(10, 5, null);
	}

}
