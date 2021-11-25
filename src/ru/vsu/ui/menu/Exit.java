package ru.vsu.ui.menu;

public class Exit implements Executable {

    @Override
    public void print(int a) {
        System.out.println(a + ". Exit");
    }

    @Override
    public void execute() {

    }
}
