package ru.vsu.ui.menu;

public class ViewStock implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". View items in stock");
    }

    @Override
    public void execute() {
        repositoryCLIAdapter.viewStock();
    }
}
