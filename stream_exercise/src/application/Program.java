package application;

import entities.Employee;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full file path: ");
        String path = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> employees = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                employees.add(new Employee( fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            List<String> emails = employees.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(e -> e.getEmail())
                    .sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            double sum = employees.stream()
                    .filter(e -> e.getName().startsWith("M"))
                    .map(Employee::getSalary)
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sum);

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
