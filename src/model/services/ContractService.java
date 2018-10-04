package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	private Contract contract;
	private List<Installment> installment = new ArrayList<>();

	public ContractService() {
	}

	public ContractService(Contract contract, OnlinePaymentService onlinePaymentService) {
		super();
		this.contract = contract;
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(int months) {

		double amount = contract.getTotalValue() / months;
		Date dueDate = contract.getDate();

		for (int i = 1; i <= months; i++) {

			double opsInterest = onlinePaymentService.interest(amount, i);
			double payfee = onlinePaymentService.paymentFee(opsInterest);

			Calendar c = Calendar.getInstance();
			c.setTime(dueDate);
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) + i);
			Date dt = c.getTime();

			installment.add(new Installment(dt, payfee));
		}
		contract.setInstallment(installment);
	}
}
