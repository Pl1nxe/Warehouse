package ru.vsu.services.adapters;

import ru.vsu.items.Item;
import ru.vsu.repository.HandlerOfWarehouses;
import ru.vsu.repository.Stored;
import ru.vsu.services.builders.ItemFromCLIBuilder;

import java.util.Scanner;

public class ItemsCLIAdapter implements Adapter {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public void add() {
        Item item = ItemFromCLIBuilder.createItem();
        System.out.print("Choose warehouse (number): ");
        Integer num = scn.nextInt();
        HandlerOfWarehouses.getInstance().addItem(num, item);
    }

    @Override
    public void removeByID() {
        System.out.print("Enter item article: ");
        Integer num = scn.nextInt();
        HandlerOfWarehouses.getInstance().removeItem(num);
    }

    @Override
    public void viewList() {
        System.out.print("Choose warehouse (number): ");
        Integer num = scn.nextInt();
        System.out.printf("Items in warehouse #%s:", num);
        for (Stored item : HandlerOfWarehouses.getInstance().findByID(num).getAll()) {
            System.out.println(item.toString());
        }
    }
}
