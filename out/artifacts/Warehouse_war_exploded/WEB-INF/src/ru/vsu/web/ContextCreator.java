package ru.vsu.web;

import ru.vsu.database.services.*;
import ru.vsu.tools.converters.DecimalConverter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextCreator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContextListener.super.contextInitialized(servletContextEvent);
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("decimal_converter", DecimalConverter.getInstance());
        servletContext.setAttribute("customer", CustomerDBService.getInstance());
        servletContext.setAttribute("price_list", PriceListDBService.getInstance());
        servletContext.setAttribute("item", ItemDBService.getInstance());
        servletContext.setAttribute("ordered_item", OrderedItemDBService.getInstance());
        servletContext.setAttribute("item_in_storage", ItemInStorageDBService.getInstance());
        servletContext.setAttribute("ordering", OrderingDBService.getInstance());
        servletContext.setAttribute("warehouse", WarehouseDBService.getInstance());
    }

}
