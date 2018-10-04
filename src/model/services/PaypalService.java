package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double paymentFee(Double amount) {
		// TODO Auto-generated method stub
		double aux = amount;
		double perc = aux * 2 / 100;
		double soma = aux + perc;
		return soma;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		// TODO Auto-generated method stub
		double aux = amount;
		double perc = (aux * 1 / 100) * months;
		double soma = aux + perc;
		double result = soma;
		return result;
	}
}
