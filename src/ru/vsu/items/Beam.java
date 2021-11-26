package ru.vsu.items;

public class Beam extends Item {

    private Integer length, width, height;
    private String material;

    public Beam(Integer articleNum, String title, String manufacturer, Integer price, Integer length, Integer width, Integer height, String material) {
        super(articleNum, title, manufacturer, price);
        this.length = length;
        this.width = width;
        this.height = height;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Beam{" +
                "title='" + super.title + '\'' +
                ", manufacturer='" + super.manufacturer + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", material='" + material + '\'' +
                ", price='" + super.price + '}';
    }
}
