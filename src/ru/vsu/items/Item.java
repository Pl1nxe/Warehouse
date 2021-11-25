package ru.vsu.items;

import ru.vsu.repository.Stored;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Item implements Stored {

    protected String title, manufacturer;
    protected Integer price, articleNum;
    private AtomicInteger articleGenerator = new AtomicInteger(0);


    public Item(String title, String manufacturer, Integer price) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        articleNum = articleGenerator.getAndIncrement();
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

}
