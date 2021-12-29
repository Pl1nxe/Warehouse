package ru.vsu.items;

public class Pipe extends Item {

    public Pipe(Integer articleNum, String title, String manufacturer, Integer price, Integer innerDiameter,
                Integer outerDiameter, String material) {
        super(articleNum, title, manufacturer, price, null, null, null, material, null,
              innerDiameter, outerDiameter);
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price='" + price + '}';
    }
}
