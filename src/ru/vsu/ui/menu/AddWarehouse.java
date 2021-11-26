package ru.vsu.ui.menu;

public class AddWarehouse implements Executable {
    @Override
    public void print(int a) {
        System.out.println(a + ". Add warehouses");
    }

    @Override
    public void execute() {
        warehousesCLIAdapter.add();
    }
}
