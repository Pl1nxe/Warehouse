package ru.vsu.ui;

import ru.vsu.services.adapters.WarehousesCLIAdapter;
import ru.vsu.ui.menu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI implements UI{

    private boolean runnable = true;
    private final WarehousesCLIAdapter repositoryCLIAdapter = new WarehousesCLIAdapter();
    private List<Executable> menu = new ArrayList<>();

    public CLI() {
        menu.add(new AddWarehouse());
        menu.add(new AddItem());
        menu.add(new AddCustomer());
        menu.add(new MakeOrder());
        menu.add(new ViewWarehouses());
        menu.add(new ViewItems());
        menu.add(new ViewClientele());
        menu.add(new ViewOrders());
        menu.add(new RemoveWarehouse());
        menu.add(new RemoveItem());
        menu.add(new RemoveCustomer());
        menu.add(new RemoveOrder());
    }

    @Override
    public void run() {
        Scanner scn = new Scanner(System.in);
        while (runnable) {
            printMenu();
            try {
                runnable = execute(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("--> Error!!! Incorrect input. <--");
            }
        }
    }

    private boolean execute(int n) {
        n--;
        if (n == menu.size())
            return false;
        else if (n >= 0 && n < menu.size()) {
            menu.get(n).execute();
            return true;
        }
        System.out.println("Incorrect operation");
        return true;
    }

    private void printMenu() {
        System.out.print("\nMenu:\n");
        for (int i = 0; i < menu.size(); i++)
            menu.get(i).print(i + 1);
        System.out.printf("%s. Exit\n", menu.size() + 1);
    }

}
