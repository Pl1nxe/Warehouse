package ru.vsu.customers;

public class LegalPerson extends Customer {

    private String nameOfOrganization;

    public LegalPerson(String nameOfOrganization, Integer personalTaxNumber, String address) {
        super(personalTaxNumber, address);
        this.nameOfOrganization = nameOfOrganization;
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
                "nameOfOrganization='" + nameOfOrganization + '\'' +
                ", ITN='" + super.ITN + '\'' +
                ", address='" + super.address + '}';
    }

}
