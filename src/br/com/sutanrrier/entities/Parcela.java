package br.com.sutanrrier.entities;

import java.time.LocalDate;

public class Parcela {
	private LocalDate dataVencimento;
	private Double valorParcela;
	
	public Parcela(LocalDate dataVencimento, Double valorParcela) {
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public Double getValorParcela() {
		return valorParcela;
	}
}