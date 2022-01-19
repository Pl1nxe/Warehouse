package ru.vsu.database.objects;

public class ItemInStorage {

    private Integer warehouseNum, itemArticle;

    public ItemInStorage(Integer warehouseNum, Integer itemArticle) {
        this.itemArticle = itemArticle;
        this.warehouseNum = warehouseNum;
    }

    public Integer getWarehouseNum() {
        return warehouseNum;
    }

    public Integer getItemArticle() {
        return itemArticle;
    }
}
