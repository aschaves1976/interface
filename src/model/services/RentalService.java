package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;

	private TaxService taxService;

	public RentalService() {
	}

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		// no java as datas são armazenadas em milissegundos. Vamos utilizar getTime()
		// para capturar o valor da data em milissegundo

		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		/*
		 * achar a diferença em horas: estamos utilizando um cast para double para
		 * garantir que o resultado seja double queremos que o resultado venha com horas
		 * quebradas para que possamos arredondar(Math.ceil(double arg)) para cima t1-t2
		 * = retorna a diferença em milissegundos (t1-t2) / 1000 = retorna a diferença
		 * em segundos (t1-t2) / 1000 / 60 = retorna a diferença em minutos (t1-t2) /
		 * 1000 / 60 / 60 = retorna a diferença em horas
		 */
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicPayment;

		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		} else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}

		double tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}