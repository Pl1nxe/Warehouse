package ru.vsu.services.adapters;

import ru.vsu.repository.HandlerOfWarehouses;
import ru.vsu.repository.Stored;
import ru.vsu.repository.Warehouse;
import ru.vsu.services.builders.WarehouseFromCLIBuilder;

import java.util.Scanner;

public class WarehousesCLIAdapter implements Adapter {

    private final Scanner scn = new Scanner(System.in);

    @Override
    public void add() {
        Warehouse warehouse = WarehouseFromCLIBuilder.createWarehouse();
        HandlerOfWarehouses.getInstance().add(warehouse);
    }

    @Override
    public void removeByID() {
        System.out.print("Enter warehouse number: ");
        Integer num = scn.nextInt();
        HandlerOfWarehouses.getInstance().removeByID(num);
    }

    @Override
    public void viewList() {
        System.out.println("Existing warehouses:");
        for (Stored warehouse : HandlerOfWarehouses.getInstance().getAll()) {
            System.out.println(warehouse.toString());
        }
    }

}

