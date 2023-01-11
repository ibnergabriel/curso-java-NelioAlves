package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Birth date: ");
        String birthDate = scanner.nextLine();

        Client client = new Client(name, email, sdf1.parse(birthDate));

        System.out.println("Enter the order data: ");
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Order order = new Order( sdf2.parse(String.valueOf(new Date(System.currentTimeMillis()))),
                OrderStatus.valueOf(status),
                client);

        System.out.println();
        System.out.print("How many items to this order? ");
        int quantityItems = scanner.nextInt();



    }

}
