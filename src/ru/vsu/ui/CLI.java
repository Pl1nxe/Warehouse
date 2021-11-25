package ru.vsu.ui;

import ru.vsu.services.adapters.WarehouseCLIAdapter;

import java.util.Scanner;

public class CLI implements UI{

    private boolean runnable = true;
    private final WarehouseCLIAdapter repositoryCLIAdapter = new WarehouseCLIAdapter();

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
            case 1 -> repositoryCLIAdapter.addItem();
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
