package ru.vsu.services.builders;

import ru.vsu.customers.Customer;
import ru.vsu.customers.LegalPerson;
import ru.vsu.customers.PrivatePerson;

import java.util.Scanner;

public class CustomerFromCLIBuilder {

    private static final Scanner scn = new Scanner(System.in);

    public static Customer createCustomer() {
        System.out.println("""
        Choose:
        1. Legal person
        2. Private person
        """);
        int a = scn.nextInt();
        if (a == 1)
            return createLegalPerson();
        else if (a == 2)
            return createPrivatePerson();
        else {
            System.out.println("Not found command!");
            return createCustomer();
        }
    }

    public static LegalPerson createLegalPerson() {
        return new LegalPerson(nameOfOrganization(), personalTaxNumber(), address());
    }

    public static PrivatePerson createPrivatePerson() {
        return new PrivatePerson(fullName(), birthDate(), personalTaxNumber(), address());
    }

    private static String nameOfOrganization() {
        System.out.print("Name of organization: ");
        return scn.nextLine();
    }

    private static Integer personalTaxNumber() {
        System.out.print("Personal tax number: ");
        return scn.nextInt();
    }

    private static String address() {
        System.out.print("Address: ");
        return scn.nextLine();
    }

    private static String fullName() {
        System.out.print("Full name: ");
        return scn.nextLine();
    }

    private static String birthDate() {
        System.out.print("Birth date: ");
        return scn.nextLine();
    }
}
