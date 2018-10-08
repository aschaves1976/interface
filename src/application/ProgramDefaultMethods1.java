package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.BrazilInterestService;
import model.services.InterestService;
import model.services.UsaInterestService;

public class ProgramDefaultMethods1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		InterestService bis = new BrazilInterestService(2.0);
		double payment = bis.payment(amount, months);

		System.out.print("Brazil Payment after " + months + " months: ");
		System.out.println(String.format("$%.2f ", payment));

		bis = new UsaInterestService(1.0);
		payment = bis.payment(amount, months);

		System.out.print("USA Payment after " + months + " months: ");
		System.out.println(String.format("$%.2f ", payment));

		sc.close();

	}

}
