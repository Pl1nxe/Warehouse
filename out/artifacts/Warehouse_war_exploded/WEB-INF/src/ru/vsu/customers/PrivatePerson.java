package ru.vsu.customers;

public class PrivatePerson extends Customer {

    public PrivatePerson(String fullName, String birthDate, Integer individualTaxpayerNumber, String address) {
        super(individualTaxpayerNumber, address, fullName, birthDate);
    }

    @Override
    public String toString() {
        return "PrivatePerson{" +
                "fullName='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", ITN='" + ITN + '}';
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
