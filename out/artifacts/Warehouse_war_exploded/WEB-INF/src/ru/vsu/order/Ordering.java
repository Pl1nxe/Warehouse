package ru.vsu.order;

public class Ordering {

    private Integer referenceNumber;
    private String date;
    private Integer customerITN;

    public Ordering(Integer referenceNumber, Integer customerITN, String date) {
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.customerITN = customerITN;
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
}
