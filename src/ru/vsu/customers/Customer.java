package ru.vsu.customers;

import ru.vsu.repository.Stored;

import java.util.Objects;

public abstract class Customer implements Stored {

    protected Integer ITN;
    protected String address;
    protected String nameOfOrganization;
    protected String fullName;
    protected String birthDate;

    public Customer(Integer individualTaxpayerNumber,
                    String address,
                    String nameOfOrganization,
                    String fullName,
                    String birthDate) {
        this.address = address;
        ITN = individualTaxpayerNumber;
        this.nameOfOrganization = nameOfOrganization;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    @Override
    public Integer getID() {
        return ITN;
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

    public Integer getITN() {
        return ITN;
    }

    public String getAddress() {
        return address;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
