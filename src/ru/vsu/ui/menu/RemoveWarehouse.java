package ru.vsu.ui.menu;

public class RemoveWarehouse implements Executable{
    @Override
    public void print(int a) {
        System.out.println(a + ". Remove warehouse");
    }

    @Override
    public void execute() {
        warehousesCLIAdapter.removeByID();
    }
}
