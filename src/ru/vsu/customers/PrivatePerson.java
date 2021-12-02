package ru.vsu.customers;

public class PrivatePerson extends Customer {

    public PrivatePerson(String fullName, String birthDate, Integer individualTaxpayerNumber, String address) {
        super(individualTaxpayerNumber, address, null, fullName, birthDate);
    }

    @Override
    public String toString() {
        return "PrivatePerson{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", ITN='" + ITN + '}';
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
