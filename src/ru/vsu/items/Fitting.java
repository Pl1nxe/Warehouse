package ru.vsu.items;

public class Fitting extends Item {

    private Integer length, thickness;

    public Fitting(Integer articleNum, String title, String manufacturer, Integer price, Integer length, Integer thickness) {
        super(articleNum, title, manufacturer, price);
        this.thickness = thickness;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Fitting{" +
                "title='" + super.title + '\'' +
                ", manufacturer='" + super.manufacturer + '\'' +
                ", thickness='" + thickness + '\'' +
                ", length='" + length + '\'' +
                ", price='" + super.price + '}';
    }
}
