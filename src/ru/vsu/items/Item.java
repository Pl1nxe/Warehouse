package ru.vsu.items;

import ru.vsu.repository.Stored;

import java.util.Objects;

public abstract class Item implements Stored {

    protected String title;
    protected  String manufacturer;
    protected Integer price;
    protected Integer articleNum;
    protected Integer length;
    protected Integer width;
    protected Integer height;
    protected String material;
    protected Integer thickness;
    protected Integer innerDiameter;
    protected Integer outerDiameter;


    public Item(Integer articleNum,
                String title,
                String manufacturer,
                Integer price,
                Integer length,
                Integer width,
                Integer height,
                String material,
                Integer thickness,
                Integer innerDiameter,
                Integer outerDiameter) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.articleNum = articleNum;
        this.length = length;
        this.width = width;
        this.height = height;
        this.material = material;
        this.thickness = thickness;
        this.innerDiameter = innerDiameter;
        this.outerDiameter = outerDiameter;
    }

    @Override
    public Integer getID() {
        return articleNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(articleNum, item.articleNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleNum);
    }

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getThickness() {
        return thickness;
    }

    public Integer getInnerDiameter() {
        return innerDiameter;
    }

    public Integer getOuterDiameter() {
        return outerDiameter;
    }
}
