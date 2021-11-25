package ru.vsu.repository;

import ru.vsu.order.Order;

import java.util.ArrayList;
import java.util.List;

public class HandlerOfOrders implements Repository {

    private static HandlerOfOrders INSTANCE;
    private final List<Order> orders;

    private HandlerOfOrders(){
        orders = new ArrayList<>();
    }

    public static HandlerOfOrders getInstance(){
        if (INSTANCE == null) INSTANCE = new HandlerOfOrders();
        return INSTANCE;
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public void add(Stored order) {
        orders.add((Order) order);
    }

    @Override
    public void deleteByIndex(int index) {
        orders.remove(index);
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
}
