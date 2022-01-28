package ru.vsu.database.objects;

public class ItemInStorage {

    private Integer warehouseNum, itemArticle, count;

    public ItemInStorage(Integer warehouseNum, Integer itemArticle, int count) {
        this.itemArticle = itemArticle;
        this.warehouseNum = warehouseNum;
        this.count = count;
    }

    public Integer getWarehouseNum() {
        return warehouseNum;
    }

    public Integer getItemArticle() {
        return itemArticle;
    }

    public Integer getCount() {
        return count;
    }
}
