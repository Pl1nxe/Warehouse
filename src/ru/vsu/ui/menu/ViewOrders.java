package ru.vsu.ui.menu;

public class ViewOrders implements Executable{
    @Override
    public void print(int a) {
        System.out.println(a + ". View orders");
    }

    @Override
    public void execute() {
        orderCLIAdapter.viewList();
    }
}
