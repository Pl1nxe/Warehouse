package ru.vsu.ui.menu;

public class RemoveCustomer implements Executable {
    @Override
    public void print(int a) {
        System.out.println(a + ". Remove customer");
    }

    @Override
    public void execute() {
        clienteleCLIAdapter.removeByID();
    }
}
