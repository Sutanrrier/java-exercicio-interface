package br.com.sutanrrier.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private Integer numeroContrato;
	private LocalDate dataContrato;
	private Double valorTotal;
	private List<Parcela> parcelasContrato;
	
	public Contract(Integer numeroContrato, LocalDate dataContrato, Double valorTotal) {
		this.numeroContrato = numeroContrato;
		this.dataContrato = dataContrato;
		this.valorTotal = valorTotal;
		parcelasContrato = new ArrayList<>();
	}

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public LocalDate getDataContrato() {
		return dataContrato;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void adicionarParcela(LocalDate dataVencimento, Double valorParcela) {
		Parcela parcela = new Parcela(dataVencimento, valorParcela);
		parcelasContrato.add(parcela);
	}

	public List<Parcela> getParcelasContrato() {
		return parcelasContrato;
	}
}
