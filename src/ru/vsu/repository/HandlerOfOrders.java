package ru.vsu.repository;

import ru.vsu.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandlerOfOrders implements Repository {

    private static HandlerOfOrders INSTANCE;
    private final List<Order> orders;

    private HandlerOfOrders() {
        orders = new ArrayList<>();
    }

    public static HandlerOfOrders getInstance() {
        if (INSTANCE == null) INSTANCE = new HandlerOfOrders();
        return INSTANCE;
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public void add(Stored order) {
        try {
            orders.add((Order) order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteByIndex(int index) {
        try {
            orders.remove(index);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void replaceAll(Stored existing, Stored toReplace) {
        try {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i) == existing) orders.set(i, (Order) toReplace);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Order getElementByID(Integer id) {
        return orders.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }

    public static Order findByID(Integer id) {
        List<Stored> order = getInstance().getAll().stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList());
        return (Order) order.get(0);
    }
}
