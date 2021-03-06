package ru.vsu.repository;

import ru.vsu.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Warehouse implements Repository, Stored {
    private final List<Item> items;
    private Integer number;
    private String address;

    public Warehouse(Integer number, String address) {
        items = new ArrayList<>();
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "number='" + number + '\'' +
                ", address='" + address + '}';
    }

    @Override
    public Integer getID() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void add(Stored item) {
        try {
            items.add((Item) item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteByIndex(int index) {
        try {
            items.remove(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeByID(Integer id) {
        items.remove(getElementByID(id));
    }

    @Override
    public void replaceElement(Stored existing, Stored toReplace) {
        try {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) == existing) items.set(i, (Item) toReplace);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void replaceList(List<Stored> elements) {
        try {
            for (Stored i : elements) {
                Item el = getElementByID(i.getID());
                if (el != null)
                    el = (Item) i;
                else
                    items.add((Item) i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Item getElementByID(Integer id) {
        return items.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }

    public Item findByID(Integer id) {
        List<Item> item = new ArrayList<>(items.stream().filter(var -> var.getID().equals(id)).
                collect(Collectors.toList()));
        return (Item) item.get(0);
    }
}
