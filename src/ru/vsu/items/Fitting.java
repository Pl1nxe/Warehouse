package ru.vsu.items;

public class Fitting extends Item {

    private Integer length, thickness;

    public Fitting(Integer articleNum, String title, String manufacturer, Integer price, Integer length, Integer thickness) {
        super(articleNum, title, manufacturer, price, length, null, null, null, thickness,
                null, null);
    }

    @Override
    public String toString() {
        return "Fitting{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", thickness='" + thickness + '\'' +
                ", length='" + length + '\'' +
                ", price='" + price + '}';
    }
}
