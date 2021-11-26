package ru.vsu.services.builders;


import ru.vsu.customers.Customer;
import ru.vsu.order.Order;
import ru.vsu.repository.Clientele;

import java.util.Scanner;

public class OrderFromCLIBuilder {
    private static final Scanner scn = new Scanner(System.in);

    public static Order createOrder() {
        return new Order(referenceNumber(), customer(), date());
    }

    private static Integer referenceNumber() {
        System.out.print("Reference number: ");
        return scn.nextInt();
    }

    private static String date() {
        System.out.print("Date: ");
        return scn.nextLine();
    }

    private static Customer customer() {
        System.out.println("""
        Choose:
        1. New customer
        2. Existing customer
        """);
        int a = scn.nextInt();
        if (a == 1) {
            return CustomerFromCLIBuilder.createCustomer();
        } else if (a == 2) {
            System.out.print("Write ITN: ");
            Integer num = scn.nextInt();
            return Clientele.findByID(num);
        } else {
            System.out.println("Not found command!");
            return customer();
        }
    }
}
