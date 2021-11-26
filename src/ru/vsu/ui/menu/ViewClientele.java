package ru.vsu.ui.menu;

public class ViewClientele implements Executable{


    @Override
    public void print(int a) {
        System.out.println(a + ". View clientele");
    }

    @Override
    public void execute() {
        clienteleCLIAdapter.viewList();
    }
}
