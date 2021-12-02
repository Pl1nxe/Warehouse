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

//        db.executeSelect("INSERT INTO item (article, title, price, manufacturer) VALUES (" + item.getArticleNum()
//                + ", `" + item.getTitle() + "`, " + item.getPrice() + ", `" + item.getManufacturer() + "`);");
//        db.executeSelect("INSERT INTO item_in_storage (item_article, warehouse_number) VALUES ("
//                + item.getArticleNum() + ", " + num + ");");
    }

    @Override
    public void removeByID() {
        System.out.print("Enter item article: ");
        Integer num = scn.nextInt();
        HandlerOfWarehouses.getInstance().removeItem(num);

//        db.executeSelect("DELETE FROM item WHERE article=" + num + ";");
//        db.executeSelect("DELETE FROM item_in_storage WHERE article=" + num + ";");
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

    public void viewDataBase() {

    }


}
