package ru.vsu.order;

import ru.vsu.customers.Customer;
import ru.vsu.items.*;
import ru.vsu.repository.Stored;

import java.util.ArrayList;
import java.util.List;

public class Order implements Stored {

    private Integer referenceNumber;
    private Customer customer;
    private String date;
    private List<Item> items;
    private Integer customerITN;

    public Order(Integer referenceNumber, Customer customer, String date) {
        this.referenceNumber = referenceNumber;
        this.customer = customer;
        this.date = date;
        customerITN = customer.getITN();
    }

    @Override
    public Integer getID() {
        return referenceNumber;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        String text = "Order{" +
                "number='" + referenceNumber + '\'';
        text += customer.toString();
        for (Item var: items) {
            text += var.toString();
        }
        text += '}';
        return text;
    }

    public Integer getReferenceNumber() {
        return referenceNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public double getCost() {
        double cost = 0;
        for (Item item : items)
            cost += item.getPrice();
        return cost;
    }

    public Integer getCustomerITN() {
        return customerITN;
    }
}
