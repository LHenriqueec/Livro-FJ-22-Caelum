package br.com.caelum.argentum.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.builder.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactory {

	@Test
	public void testeFactory() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle);
	}
	
	@Test
	public void testeBuilder() {
		Candlestick candle = new CandleBuilder().comAbertura(40.5)
				.comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
				.comVolume(145234.20).comData(new GregorianCalendar(2008, 8, 12, 0, 0, 0)).geraCandle();
		
		System.out.println(candle);
	}
	
	@Test
	public void testando_uma_negociacao() {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle);
	}
	
	@Test
	public void sem_negociacoes() {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = Arrays.asList();
		
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle);
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
		
		System.out.println(candle);
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
		
		System.out.println(candle);
	}
}
