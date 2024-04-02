package applications;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptionAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Informe os dados da conta");
			System.out.print("Numero: ");
			int number = sc.nextInt();
			
			System.out.print("Titular: ");
			sc.nextLine();
			String holder = sc.nextLine();
			
			System.out.print("Saldo inicial: ");
			double balance = sc.nextDouble();
			
			System.out.print("Limite de saque: ");
			double withdrawLimit = sc.nextDouble();

			
			Account account = new Account(number, holder, balance, withdrawLimit);	
			
			System.out.print("Enter amount for withdraw:");
			Double amountWithDraw = sc.nextDouble();
			
			account.withDraw(amountWithDraw);
			System.out.printf("Novo saldo: %.2f%n", account.getBalance());
			
		} catch(DomainExceptionAccount e) {
			System.out.print("Withdraw error: "+ e.getMessage());
		} catch (Exception e) {
			 System.out.print("Error inexpected");
		}
		
		sc.close();

	}

}
  

