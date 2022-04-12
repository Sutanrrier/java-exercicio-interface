package br.com.sutanrrier.services;

public interface PaymentService{
	
	public Double taxaPagamento(Double valor);
	public Double calcularJuros(Double valor, Integer meses);
}
