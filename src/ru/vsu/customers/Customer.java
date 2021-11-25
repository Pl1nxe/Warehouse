package ru.vsu.customers;

import ru.vsu.repository.Stored;

import java.util.Objects;

public abstract class Customer implements Stored {

    protected Integer ITN;
    protected String address;

    public Customer(Integer individualTaxpayerNumber, String address) {
        this.address = address;
        ITN = individualTaxpayerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ITN, customer.ITN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ITN);
    }
}
