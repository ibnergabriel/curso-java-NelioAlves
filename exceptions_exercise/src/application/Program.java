package application;

import Model.entities.Account;
import Model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account data: ");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Holder: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = scanner.nextDouble();

        Account acc = new Account(number,holder,balance,withdrawLimit);

        try {
            System.out.print("Enter the amount for withdraw: ");
            acc.withdraw(scanner.nextDouble());
            System.out.println("Update balance: " + String.format("%.2f",acc.getBalance()));
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
