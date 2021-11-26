package ru.vsu.ui.menu;

public class ViewItems implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". View items in stock");
    }

    @Override
    public void execute() {
        warehousesCLIAdapter.viewList();
    }
}
