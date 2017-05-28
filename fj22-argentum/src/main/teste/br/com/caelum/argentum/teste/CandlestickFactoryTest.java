package br.com.caelum.argentum.teste;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.builder.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class CandlestickFactoryTest {

	@Test
	public void sequencia_simples_de_negociacoes() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.constroiCandleParaData(hoje, negociacoes);
		
		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(42.3, candle.getFechamento(), 0.00001);
		assertEquals(39.8, candle.getMinimo(), 0.00001);
		assertEquals(45.0, candle.getMaximo(), 0.00001);
		assertEquals(16760.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void testeBuilder() {
		Candlestick candle = new CandleBuilder().comAbertura(40.5)
				.comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
				.comVolume(145234.20).comData(new GregorianCalendar(2008, 8, 12, 0, 0, 0)).geraCandle();
		
		assertEquals(candle.getAbertura(), 40.5, 0.00001);
		assertEquals(candle.getFechamento(), 42.3, 0.00001);
		assertEquals(candle.getMinimo(), 39.8, 0.00001);
		assertEquals(candle.getMaximo(), 45.0, 0.00001);
		assertEquals(candle.getVolume(), 145234.20, 0.00001);
		
		Calendar date = new GregorianCalendar(2008, 8, 12, 0, 0, 0);
		assertEquals(candle.getData(), date);
	}
	
	@Test
	public void testando_uma_negociacao_gera_candle_com_valores_iguais() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		assertEquals(candle.getAbertura(), candle.getFechamento(), 0.00001);
		assertEquals(candle.getMaximo(), candle.getMaximo(), 0.00001);
	}
	
	@Test
	public void sem_negociacoes() {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = Arrays.asList();
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		assertEquals(0.0, candle.getVolume(), 0.00001);
		assertEquals(0.0, candle.getAbertura(), 0.00001);
		assertEquals(0.0, candle.getFechamento(), 0.00001);
		assertEquals(0.0, candle.getMaximo(), 0.00001);
		assertEquals(0.0, candle.getMinimo(), 0.00001);
	}
	
	@Test
	public void negociacoes_decrescentes() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(53.3, 100, hoje);
		Negociacao negociacao2 = new Negociacao(49.8, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		assertEquals(53.3, candle.getAbertura(), 0.00001);
		assertEquals(40.5, candle.getFechamento(), 0.00001);
	}
	
	@Test
	public void negociacoes_crescentes() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(53.3, 100, hoje);
		Negociacao negociacao2 = new Negociacao(49.8, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao4, negociacao3, negociacao2, negociacao1);
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(53.3, candle.getFechamento(), 0.00001);
	}
}
