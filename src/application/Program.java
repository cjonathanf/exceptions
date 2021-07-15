package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Account account = new Account();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimite = sc.nextDouble();
			account = new Account(number, holder, balance, withdrawLimite);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(sc.nextDouble());
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());

		} catch (RuntimeException e) {
			System.out.println("Unexpected error");

		}

		sc.close();
	}

}
