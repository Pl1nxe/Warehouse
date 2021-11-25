package ru.vsu.repository;

import ru.vsu.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Repository {
    private static Warehouse INSTANCE;
    private final List<Item> items;

    private Warehouse(){
        items = new ArrayList<>();
    }

    public static Warehouse getInstance(){
        if (INSTANCE == null) INSTANCE = new Warehouse();
        return INSTANCE;
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void add(Stored item) {
        items.add(item);
    }

    @Override
    public void deleteByIndex(int index) {
        items.remove(index);
    }

    @Override
    public void replaceAll(Stored existing, Stored toReplace) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == existing) items.set(i, toReplace);
        }
    }
}
