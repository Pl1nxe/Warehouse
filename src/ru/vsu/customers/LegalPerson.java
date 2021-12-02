package ru.vsu.customers;

public class LegalPerson extends Customer {

    public LegalPerson(String nameOfOrganization, Integer individualTaxpayerNumber, String address) {
        super(individualTaxpayerNumber, address, nameOfOrganization, null, null);
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
                "nameOfOrganization='" + nameOfOrganization + '\'' +
                ", ITN='" + ITN + '\'' +
                ", address='" + address + '}';
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }
}
