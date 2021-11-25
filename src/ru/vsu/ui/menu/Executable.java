package ru.vsu.ui.menu;

import ru.vsu.services.*;

public interface Executable {

    WarehouseCLIAdapter repositoryCLIAdapter = new WarehouseCLIAdapter();
    ClienteleCLIAdapter clienteleCLIAdapter = new ClienteleCLIAdapter();
    OrderCLIAdapter orderCLIAdapter = new OrderCLIAdapter();

    void print(int a);

    void execute();

}
