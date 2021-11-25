package ru.vsu.repository;

import ru.vsu.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Repository {
    private final List<Item> items;
    private int number;
    private String address;

    public Warehouse(int number, String address) {
        items = new ArrayList<>();
        this.address = address;
        this.number = number;
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
            System.out.println(e);
        }
    }

    @Override
    public void deleteByIndex(int index) {
        items.remove(index);
    }

    @Override
    public void replaceAll(Stored existing, Stored toReplace) {
        try {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) == existing) items.set(i, (Item) toReplace);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
