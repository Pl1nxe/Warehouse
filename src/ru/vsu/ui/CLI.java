package ru.vsu.ui;

import ru.vsu.services.adapters.WarehousesCLIAdapter;
import ru.vsu.ui.menu.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CLI implements UI{

    private boolean runnable = true;
    private final WarehousesCLIAdapter repositoryCLIAdapter = new WarehousesCLIAdapter();
    private Map<Integer, ? extends Executable> menu;

    public CLI() {
        List<Class<? extends Executable>> ClassList = new ArrayList<Class<? extends Executable>>();

    }

    @Override
    public void run() {
        Scanner scn = new Scanner(System.in);
        while (runnable) {
            System.out.println("""
        Menu:
        1. Add Items
        2. Remove item
        3. View items in stock
        4. Exit""");
            try {
                runnable = execute(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("--> Error!!! Incorrect input. <--");
            }
        }
    }

    private boolean execute(int n) {
        switch (n) {
            case 1 -> repositoryCLIAdapter.add();
            case 2 -> repositoryCLIAdapter.removeItems();
            case 3 -> repositoryCLIAdapter.viewStock();
            case 4 -> {
                return false;
            }
            default -> System.out.println("Incorrect operation");
        }
        return true;
    }
    // pattern команды

}
