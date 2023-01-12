package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

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

        Order order = new Order( new Date(System.currentTimeMillis()),
                OrderStatus.valueOf(status),
                client);

        System.out.println();
        System.out.print("How many items to this order? ");
        int n = scanner.nextInt();


        for(int i=1; i<=n; i++){
            scanner.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = scanner.nextLine();
            System.out.print("Price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scanner.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);
            System.out.println();
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        scanner.close();

    }

}
