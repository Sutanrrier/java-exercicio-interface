package br.com.sutanrrier.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sutanrrier.entities.Contract;
import br.com.sutanrrier.entities.Parcela;

public class ContractService {
	
	PaymentService servicoPagamento = new PaypalService();
	
	//Formata a data do est ilo americano para brasileiro.
	DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void gerarContrato(Contract contrato, Integer meses) {
		for(int i=0; i<meses; i++) {
			
			//Calcula os juros da parcela
			Double valor = contrato.getValorTotal() / meses;
			valor += servicoPagamento.calcularJuros(valor, i+1);
			valor += servicoPagamento.taxaPagamento(valor);
			
			//Gera a data da parcela
			LocalDate dataVencimento = contrato.getDataContrato();
			dataVencimento = dataVencimento.withMonth(dataVencimento.getMonthValue()+(i+1));
			
			//Gera a parcela no contrato
			contrato.adicionarParcela(dataVencimento, valor);
			valor = contrato.getValorTotal();
		}
		
		System.out.println("PARCELAS:");
		for(Parcela parcela : contrato.getParcelasContrato()) {
			System.out.println(parcela.getDataVencimento().format(formatData) + " -> " + parcela.getValorParcela());
		}
	}
}
