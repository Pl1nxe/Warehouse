package ru.vsu.services.builders;

import ru.vsu.repository.Warehouse;

import java.util.Scanner;

public class WarehouseFromCLIBuilder {
    private static final Scanner scn = new Scanner(System.in);

    public static Warehouse createWarehouse() {
        return new Warehouse(number(), address());
    }

    private static Integer number() {
        System.out.print("Warehouse number: ");
        return scn.nextInt();
    }

    private static String address() {
        System.out.print("Address: ");
        return scn.nextLine();
    }
}
