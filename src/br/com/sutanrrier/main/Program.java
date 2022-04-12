package br.com.sutanrrier.main;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.com.sutanrrier.entities.Contract;
import br.com.sutanrrier.services.ContractService;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato abaixo: ");
		System.out.print("Digite o número do contrato: ");
		Integer numeroContrato = sc.nextInt();
		sc.nextLine();
		System.out.print("Digite a data contrato (dd/MM/yyyy): ");
		LocalDate dataContrato = LocalDate.parse(sc.nextLine(), formatData);
		System.out.print("Digite o valor do contrato: ");
		Double valorTotal = sc.nextDouble();
		Contract contrato = new Contract(numeroContrato, dataContrato, valorTotal);
		
		System.out.print("Informe a quantidade de parcelas para este contrato: ");
		int meses = sc.nextInt();
		
		ContractService contratoServico = new ContractService();
		contratoServico.gerarContrato(contrato, meses);
		
		System.out.println("\nFIM DO PROGRAMA!");
		sc.close();
	}
}
