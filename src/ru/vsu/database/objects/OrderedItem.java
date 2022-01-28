package ru.vsu.database.objects;

public class OrderedItem {

    private Integer orderRefNum, itemArticle, count;
    private double price;

    public OrderedItem(Integer orderRefNum, Integer itemArticle, double price, int count) {
        this.count = count;
        this.price = price;
        this.itemArticle = itemArticle;
        this.orderRefNum = orderRefNum;
    }

    public Integer getOrderRefNum() {
        return orderRefNum;
    }

    public Integer getItemArticle() {
        return itemArticle;
    }

    public Integer getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }
}
