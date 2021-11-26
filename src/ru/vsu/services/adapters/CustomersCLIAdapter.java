package ru.vsu.services.adapters;

import ru.vsu.customers.Customer;
import ru.vsu.repository.Clientele;
import ru.vsu.repository.Stored;
import ru.vsu.services.builders.CustomerFromCLIBuilder;

import java.util.Scanner;

public class CustomersCLIAdapter implements Adapter {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public void add() {
        Customer customer = CustomerFromCLIBuilder.createCustomer();
        Clientele.getInstance().add(customer);
    }

    @Override
    public void removeByID() {
        System.out.print("Enter customer ITN: ");
        Integer num = scn.nextInt();
        Clientele.getInstance().removeByID(num);
    }

    @Override
    public void viewList() {
        System.out.println("Clientele:");
        for (Stored customer : Clientele.getInstance().getAll()) {
            System.out.println(customer.toString());
        }
    }
}
