package ru.vsu.customers;

public enum CustomerType {
    LEGAL_PERSON(1, LegalPerson.class),
    PRIVATE_PERSON(2, PrivatePerson.class);

    private final int num;
    private final Class<? extends Customer> type;

    CustomerType(int num, Class<? extends Customer> type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public Class<? extends Customer> getType() {
        return type;
    }

    public static CustomerType getTypeFromTypeNumber(int typeNumber) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.getNum() == typeNumber) return customerType;
        }
        return null;
    }

    public static CustomerType getTypeFromClass(Class<? extends Customer> customerClass) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.getType() == customerClass) return customerType;
        }
        return null;
    }
}
