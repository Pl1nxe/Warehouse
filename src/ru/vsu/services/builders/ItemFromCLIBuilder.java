package ru.vsu.services.builders;

import ru.vsu.items.Beam;
import ru.vsu.items.Fitting;
import ru.vsu.items.Item;
import ru.vsu.items.Pipe;

import java.util.Scanner;

public class ItemFromCLIBuilder {
    private static final Scanner scn = new Scanner(System.in);

    public static Item createItem() {
        System.out.println("""
                Choose:
                1. Bean
                2. Fitting
                3. Pipe
                """);
        int a = scn.nextInt();
        if (a == 1)
            return createBeam();
        else if (a == 2)
            return createFitting();
        else if (a == 3)
            return createPipe();
        else {
            System.out.println("Not found command!");
            return createItem();
        }
    }

    public static Beam createBeam() {
        return new Beam(getArticleNum(), getTitle(), getManufacturer(), getPrice(), getLength(), getWidth(), getHeight(), getMaterial());
    }

    public static Fitting createFitting() {
        return new Fitting(getArticleNum(), getTitle(), getManufacturer(), getPrice(), getLength(), getThickness());
    }

    public static Pipe createPipe() {
        return new Pipe(getArticleNum(), getTitle(), getManufacturer(), getPrice(), getInnerDiameter(), getOuterDiameter(), getMaterial());
    }

    private static String getTitle() {
        System.out.print("Title: ");
        return scn.nextLine();
    }

    private static String getManufacturer() {
        System.out.print("Manufacturer: ");
        return scn.nextLine();
    }

    private static Integer getArticleNum() {
        System.out.print("Article number: ");
        return scn.nextInt();
    }

    private static Integer getPrice() {
        System.out.print("Price: ");
        return scn.nextInt();
    }

    private static Integer getLength() {
        System.out.print("Length: ");
        return scn.nextInt();
    }

    private static Integer getWidth() {
        System.out.print("Width: ");
        return scn.nextInt();
    }

    private static Integer getHeight() {
        System.out.print("Height: ");
        return scn.nextInt();
    }

    private static Integer getInnerDiameter() {
        System.out.print("Inner diameter: ");
        return scn.nextInt();
    }

    private static Integer getOuterDiameter() {
        System.out.print("Outer diameter: ");
        return scn.nextInt();
    }

    private static Integer getThickness() {
        System.out.print("Thickness: ");
        return scn.nextInt();
    }

    private static String getMaterial() {
        System.out.print("Material: ");
        return scn.nextLine();
    }

}
