package ru.vsu.items;

public class Pipe extends Item {

    private Integer innerDiameter, outerDiameter;
    private String material;

    public Pipe(Integer articleNum, String title, String manufacturer, Integer price, Integer innerDiameter, Integer outerDiameter, String material) {
        super(articleNum, title, manufacturer, price);
        this.innerDiameter = innerDiameter;
        this.outerDiameter = outerDiameter;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "title='" + super.title + '\'' +
                ", manufacturer='" + super.manufacturer + '\'' +
                ", price='" + super.price + '}';
    }
}
