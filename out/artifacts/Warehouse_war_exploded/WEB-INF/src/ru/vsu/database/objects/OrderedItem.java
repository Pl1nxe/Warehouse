package ru.vsu.database.objects;

public class OrderedItem {

    private Integer orderRefNum, itemArticle;

    public OrderedItem(Integer orderRefNum, Integer itemArticle) {
        this.itemArticle = itemArticle;
        this.orderRefNum = orderRefNum;
    }

    public Integer getOrderRefNum() {
        return orderRefNum;
    }

    public Integer getItemArticle() {
        return itemArticle;
    }
}
