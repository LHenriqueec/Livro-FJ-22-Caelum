package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.argentum.builder.CandleBuilder;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = negociacoes.stream().max(Comparator.comparingDouble(Negociacao::getPreco)).get().getPreco();
		double minimo = negociacoes.stream().min(Comparator.comparingDouble(Negociacao::getPreco)).get().getPreco();
		double volume = negociacoes.stream().mapToDouble(Negociacao::getVolume).sum();
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new CandleBuilder().comMaximo(maximo).comMinimo(minimo).comVolume(volume)
				.comAbertura(abertura).comFechamento(fechamento).comData(data).geraCandle();
	}
}
