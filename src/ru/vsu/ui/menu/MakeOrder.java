package ru.vsu.ui.menu;

public class MakeOrder implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". Make order");
    }

    @Override
    public void execute() {
        orderCLIAdapter.add();
    }

}
