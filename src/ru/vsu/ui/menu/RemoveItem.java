package ru.vsu.ui.menu;

public class RemoveItem implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". Remove item");
    }

    @Override
    public void execute() {
        warehousesCLIAdapter.removeByID();
    }
}
