package ru.vsu.services.adapters;

import ru.vsu.order.Order;
import ru.vsu.repository.HandlerOfOrders;
import ru.vsu.repository.Stored;
import ru.vsu.services.builders.OrderFromCLIBuilder;

import java.util.Scanner;

public class OrdersCLIAdapter implements Adapter {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public void add() {
        Order order = OrderFromCLIBuilder.createOrder();
        HandlerOfOrders.getInstance().add(order);
    }

    @Override
    public void removeByID() {
        System.out.print("Enter number of order: ");
        Integer num = scn.nextInt();
        HandlerOfOrders.getInstance().deleteByIndex(num);
    }

    @Override
    public void viewList() {
        System.out.println("Existing orders:");
        for (Stored order : HandlerOfOrders.getInstance().getAll()) {
            System.out.println(order.toString());
        }
    }
}
