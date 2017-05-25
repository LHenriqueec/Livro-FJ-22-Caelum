package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}
	
	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("[Abertura ").append(abertura)
		.append(", Fechamento ").append(fechamento)
		.append(", Mínima ").append(minimo)
		.append(", Máxima ").append(maximo)
		.append(", Volume ").append(volume)
		.append(", Data ").append(format.format(data.getTime())).append("]");
		return build.toString();
	}
}
