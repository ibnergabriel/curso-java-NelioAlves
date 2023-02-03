package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scanner.nextInt();

        for(int i =1; i<=n;i++){
            System.out.println("Tax payer #" + i + " data: ");

            System.out.print("Individual or company (i/c)? ");
            char ch = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = scanner.nextDouble();

            if(ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();

                list.add(new Individual(name,annualIncome,healthExpenditures));
            } else {
                System.out.print("Numbers of employees: ");
                int numbersOfEmployees = scanner.nextInt();

                list.add(new Company(name,annualIncome,numbersOfEmployees));
            }
        }


        System.out.println();
        System.out.println("TAXES PAID: ");
        double sum = 0;
        for (TaxPayer tp: list) {
            System.out.println(tp.getName() + ": $ " +
                    String.format("%.2f", tp.tax()));
            sum += tp.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: " + String.format("%.2f",sum));
    }
}
