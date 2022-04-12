package br.com.sutanrrier.services;

public class PaypalService implements PaymentService{

	@Override
	public Double taxaPagamento(Double valor) {
		return valor * 0.02;
	}

	@Override
	public Double calcularJuros(Double valor, Integer meses) {
		return valor * 0.01 * meses;
	}

}
