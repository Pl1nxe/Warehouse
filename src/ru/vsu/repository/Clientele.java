package ru.vsu.repository;

import ru.vsu.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class Clientele implements Repository {

    private static Clientele INSTANCE;
    private final List<Customer> customers;

    private Clientele() {
        customers = new ArrayList<>();
    }

    public static Clientele getInstance() {
        if (INSTANCE == null) INSTANCE = new Clientele();
        return INSTANCE;
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public void add(Stored customer) {
        try {
            customers.add((Customer) customer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteByIndex(int index) {
        customers.remove(index);
    }

    @Override
    public void replaceAll(Stored existing, Stored toReplace) {
        try {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i) == existing) customers.set(i, (Customer) toReplace);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
