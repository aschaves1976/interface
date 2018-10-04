package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class ProgramExercice {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Contract Data
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date contractDate = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();

		Contract contract = new Contract(contractNumber, contractDate, contractValue);

		System.out.print("Enter number of installments: ");
		int numberOfMonths = sc.nextInt();

		ContractService cs = new ContractService(contract, new PaypalService());
		cs.processContract(numberOfMonths);

		System.out.println("Installments:");

		List<Installment> list = new ArrayList<>();
		list = contract.getInstallment();

		for (Installment i : list) {
			System.out.println(sdf.format(i.getDueDate()) + String.format(" - %.2f", i.getAmount()));
		}

		sc.close();

	}

}
