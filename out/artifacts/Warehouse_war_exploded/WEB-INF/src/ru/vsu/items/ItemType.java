package ru.vsu.items;

public enum ItemType {
    BEAM(1, Beam.class),
    FITTING(2, Fitting.class),
    PIPE(3, Pipe.class);

    private final int number;
    private final Class<? extends Item> type;

    ItemType(int num, Class<? extends Item> type) {
        this.number = num;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public Class<? extends Item> getType() {
        return type;
    }

    public static ItemType getTypeFromTypeNumber(int typeNumber){
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getNumber() == typeNumber) return itemType;
        }
        return null;
    }

    public static ItemType getTypeFromClass(Class<? extends Item> itemClass) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getType() == itemClass) return itemType;
        }
        return null;
    }
}
