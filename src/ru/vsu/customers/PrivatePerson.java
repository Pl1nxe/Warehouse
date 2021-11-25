package ru.vsu.customers;

public class PrivatePerson extends Customer {

    private String fullName, birthDate;

    public PrivatePerson(String fullName, String birthDate, Integer personalTaxNumber, String address) {
        super(personalTaxNumber, address);
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "PrivatePerson{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + super.address + '\'' +
                ", ITN='" + super.ITN + '}';
    }

}
