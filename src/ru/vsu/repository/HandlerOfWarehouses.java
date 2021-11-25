package ru.vsu.repository;

import java.util.ArrayList;
import java.util.List;

public class HandlerOfWarehouses implements Repository {

    private static HandlerOfWarehouses INSTANCE;
    private final List<Warehouse> warehouses;

    private HandlerOfWarehouses(){
        warehouses = new ArrayList<>();
    }

    public static HandlerOfWarehouses getInstance(){
        if (INSTANCE == null) INSTANCE = new HandlerOfWarehouses();
        return INSTANCE;
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(warehouses);
    }

    @Override
    public void add(Stored warehouse) {
        warehouses.add((Warehouse) warehouse);
    }

    @Override
    public void deleteByIndex(int index) {
        warehouses.remove(index);
    }

    @Override
    public void replaceAll(Stored existing, Stored toReplace) {
        try {
            for (int i = 0; i < warehouses.size(); i++) {
                if (warehouses.get(i) == existing) warehouses.set(i, (Warehouse) toReplace);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
