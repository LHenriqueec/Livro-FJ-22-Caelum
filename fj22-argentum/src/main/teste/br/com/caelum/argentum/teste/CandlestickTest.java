package br.com.caelum.argentum.teste;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Candlestick;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void preco_maximo_nao_pode_ser_menor_que_o_minimo() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void candlestick_com_data_nula() {
		new Candlestick(10, 20, 20, 30, 10000, null);
	}
}
