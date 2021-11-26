package ru.vsu.repository;

import ru.vsu.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void addItem(Integer warehouseNum, Item item) {
        getElementByID(warehouseNum).add(item);
    }

    public void removeItem(Integer itemArticle) {
        for (Warehouse warehouse : warehouses)
            if (warehouse.findByID(itemArticle) != null)
                warehouse.deleteByIndex(itemArticle);
    }

    @Override
    public List<Stored> getAll() {
        return new ArrayList<>(warehouses);
    }

    @Override
    public void add(Stored warehouse) {
        try {
            warehouses.add((Warehouse) warehouse);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteByIndex(int index) {
        try {
            warehouses.remove(index);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void removeByID(Integer id) {
        warehouses.remove(getElementByID(id));
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

    private Warehouse getElementByID(Integer id) {
        return warehouses.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }

    public Warehouse findByID(Integer id) {
        List<Stored> warehouse = getInstance().getAll().stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList());
        return (Warehouse) warehouse.get(0);
    }
}
