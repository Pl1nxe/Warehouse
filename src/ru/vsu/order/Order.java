package ru.vsu.order;

import ru.vsu.customers.*;
import ru.vsu.items.*;
import ru.vsu.repository.Stored;

import java.util.List;

public class Order implements Stored {

    private Integer referenceNumber;
    private Customer customer;
    private String date;
    private List<Item> items;

    public Order(Integer referenceNumber, Customer customer, String date) {
        this.referenceNumber = referenceNumber;
        this.customer = customer;
        this.date = date;
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
}
