package ru.vsu.ui.menu;

import ru.vsu.services.adapters.ClienteleCLIAdapter;
import ru.vsu.services.adapters.OrderCLIAdapter;
import ru.vsu.services.adapters.WarehouseCLIAdapter;

public interface Executable {

    WarehouseCLIAdapter repositoryCLIAdapter = new WarehouseCLIAdapter();
    ClienteleCLIAdapter clienteleCLIAdapter = new ClienteleCLIAdapter();
    OrderCLIAdapter orderCLIAdapter = new OrderCLIAdapter();

    void print(int a);

    void execute();

}
