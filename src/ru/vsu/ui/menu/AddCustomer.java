package ru.vsu.ui.menu;

public class AddCustomer implements Executable {
    @Override
    public void print(int a) {
        System.out.println(a + ". Add customer");
    }

    @Override
    public void execute() {
        clienteleCLIAdapter.add();
    }
}
