package ru.vsu.services.adapters;

import ru.vsu.items.Item;
import ru.vsu.services.builders.ItemFromCLIBuilder;

import java.util.*;

public class WarehouseCLIAdapter {

    private final Scanner scn = new Scanner(System.in);

    public void addItem() {
        System.out.println("""
      Select the item you want to add:
      1. Beam
      2. Fitting
      3. Pipe""");
        Item item = chooseItem();
        if (item == null) return;

        System.out.println("How much?");
        int choose = Integer.parseInt(scn.nextLine());
        if (choose > 0) {
            for (int i = 0; i < choose; i++) repository.add(item);
        }
    }

    public void removeItems() {
        List<Item> items = new ArrayList<>(getItems());

        if (items.size() == 0) return;

        System.out.println("Select the item you want to remove from a warehouse:");
        for (int i = 0; i < items.size(); i++) System.out.println((i + 1) + ") " + items.get(i));


        int choose = Integer.parseInt(scn.nextLine()) - 1;
        System.out.println("How much? ");
        int count = scn.nextInt();
        if (choose >= 0 && choose < items.size() && repository.getAll().indexOf(items.get(choose)) >= count) {
            for (int i = 0; i < count; i++)
                repository.deleteByIndex(repository.getAll().indexOf(items.get(choose)));
        } else {
            System.out.println("Out of range!");
        }
    }

    public void viewStock() {
        System.out.println("Stock:");
        Map<Item, Integer> catalog = getStock();
        for (Map.Entry<Item, Integer> entry : catalog.entrySet()) {
            System.out.println(entry.getKey() + " Amount in repository: " + entry.getValue());
        }
    }

    private Set<Item> getItems() {
        return new HashSet<>(repository.getAll());
    }

    private Map<Item, Integer> getStock() {
        Map<Item, Integer> stock = new HashMap<>();
        List<Item> items = repository.getAll();

        for (Item item : items) {
            if (!stock.containsKey(item)) {
                stock.put(item, 1);
            } else {
                stock.put(item, stock.get(item) + 1);
            }
        }

        return stock;
    }

    private Item chooseItem() {
        Item item = null;
        switch (Integer.parseInt(scn.nextLine())) {
            case 1 -> item = ItemFromCLIBuilder.createBeam();
            case 2 -> item = ItemFromCLIBuilder.createFitting();
            case 3 -> item = ItemFromCLIBuilder.createPipe();
            default -> System.out.println("Out of range!");
        }
        return item;
    }
}

