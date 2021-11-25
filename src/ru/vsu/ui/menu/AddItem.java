package ru.vsu.ui.menu;

public class AddItem implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". Add item");
    }

    @Override
    public void execute() {
        repositoryCLIAdapter.addItem();
    }
}
