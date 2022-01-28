package ru.vsu.order;

public class Ordering {

    private Integer referenceNumber;
    private String date;
    private Integer customerITN;
    private int type;
    private Integer warehouseNum;

    public Ordering(Integer referenceNumber, int type, Integer customerITN, String date, Integer warehouseNum) {
        this.referenceNumber = referenceNumber;
        this.type = type;
        this.date = date;
        this.customerITN = customerITN;
        this.warehouseNum = warehouseNum;
    }

    public Integer getReferenceNumber() {
        return referenceNumber;
    }

    public String getDate() {
        return date;
    }

    public Integer getCustomerITN() {
        return customerITN;
    }

    public int getType() {
        return type;
    }

    public Integer getWarehouseNum() {
        return warehouseNum;
    }
}
