package ru.vsu.ui.menu;

public class ViewWarehouses implements Executable{
    @Override
    public void print(int a) {
        System.out.println(a + ". View warehouses");
    }

    @Override
    public void execute() {
        warehousesCLIAdapter.viewList();
    }
}
