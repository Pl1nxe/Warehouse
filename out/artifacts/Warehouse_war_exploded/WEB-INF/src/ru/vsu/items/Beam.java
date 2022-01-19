package ru.vsu.items;

public class Beam extends Item {

    public Beam(Integer articleNum, String title, String manufacturer, Integer price, Integer length, Integer width,
                Integer height, String material) {
        super(articleNum, title, manufacturer, price, length, width, height, material,
                null, null, null);
    }

    @Override
    public String toString() {
        return "Beam{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", material='" + material + '\'' +
                ", price='" + price + '}';
    }
}
