package ru.vsu.repository;

import ru.vsu.customers.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            customers.remove(index);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeByID(Integer id) {
        customers.remove(getElementByID(id));
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

    private Customer getElementByID(Integer id) {
        return customers.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }

    public static Customer findByID(Integer id) {
        List<Stored> customer = getInstance().getAll().stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList());
        return (Customer) customer.get(0);
    }
}
