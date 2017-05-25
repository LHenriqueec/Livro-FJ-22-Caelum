package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.argentum.builder.CandleBuilder;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;
		double abertura = 0;
		double fechamento = 0;
		
		if (!negociacoes.isEmpty()) {
			maximo = negociacoes.stream().max(Comparator.comparingDouble(Negociacao::getPreco)).get().getPreco();
			minimo = negociacoes.stream().min(Comparator.comparingDouble(Negociacao::getPreco)).get().getPreco();
			volume = negociacoes.stream().mapToDouble(Negociacao::getVolume).sum();
			abertura = negociacoes.get(0).getPreco();
			fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		}

		return new CandleBuilder().comMaximo(maximo).comMinimo(minimo).comVolume(volume).comAbertura(abertura)
				.comFechamento(fechamento).comData(data).geraCandle();
	}
}
