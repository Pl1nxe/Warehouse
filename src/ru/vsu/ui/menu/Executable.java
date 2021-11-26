package ru.vsu.ui.menu;

import ru.vsu.services.adapters.CustomersCLIAdapter;
import ru.vsu.services.adapters.ItemsCLIAdapter;
import ru.vsu.services.adapters.OrdersCLIAdapter;
import ru.vsu.services.adapters.WarehousesCLIAdapter;

public interface Executable {

    WarehousesCLIAdapter warehousesCLIAdapter = new WarehousesCLIAdapter();
    CustomersCLIAdapter clienteleCLIAdapter = new CustomersCLIAdapter();
    OrdersCLIAdapter orderCLIAdapter = new OrdersCLIAdapter();
    ItemsCLIAdapter itemCLIAdapter = new ItemsCLIAdapter();

    void print(int a);

    void execute();

}
