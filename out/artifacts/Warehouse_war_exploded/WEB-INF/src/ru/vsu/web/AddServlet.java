package ru.vsu.web;

import ru.vsu.customers.Customer;
import ru.vsu.customers.CustomerType;
import ru.vsu.customers.LegalPerson;
import ru.vsu.customers.PrivatePerson;
import ru.vsu.database.services.*;
import ru.vsu.items.*;
import ru.vsu.order.Ordering;
import ru.vsu.repository.Warehouse;
import ru.vsu.tools.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strTable = req.getParameter("table");
        if (strTable == null)
            strTable = "0";
        int table = Integer.parseInt(strTable);
        switch (table) {
            case 1 -> req.setAttribute("form", WarehouseHtmlFormBuilder.getForm());
            case 2 -> {
                int type;
                type = Integer.parseInt(req.getParameter("type"));
                req.setAttribute("type", type);
                req.setAttribute("form", ItemHtmlFormBuilder.getForm(ItemType.getTypeFromTypeNumber(type)));
            }
            case 3 -> req.setAttribute("form", OrderingHtmlFormBuilder.getForm());
            case 4 -> {
                int type;
                type = Integer.parseInt(req.getParameter("type"));
                req.setAttribute("type", type);
                req.setAttribute("form", CustomerHtmlFormBuilder.getForm(CustomerType.getTypeFromTypeNumber(type)));
            }
            case 5 -> req.setAttribute("form", OrderedItemHtmlFormBuilder.getForm());
        }
        req.setAttribute("table", table);
        getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strTable = req.getParameter("table");
        if (strTable == null)
            strTable = "0";
        int table = Integer.parseInt(strTable);
        try {
            switch (table) {
                case 1 -> WarehouseDBService.getInstance().add(new Warehouse(
                        Integer.parseInt(req.getParameter("number")),
                        req.getParameter("address")
                ));
                case 2 -> {
                    Integer warehouseNumber = Integer.parseInt(req.getParameter("warehouse_number"));
                    if (WarehouseDBService.getInstance().getByID(warehouseNumber) != null) {
                        int type = Integer.parseInt(req.getParameter("type"));
                        Item item = itemCreator(req, type);
                        ItemDBService.getInstance().add(item);
                        ItemInStorageDBService.getInstance().add(
                                warehouseNumber,
                                item.getArticleNum()
                        );
                    }
                }
                case 3 -> {
                    Integer customerITN = Integer.parseInt(req.getParameter("customer_itn"));
                    if (CustomerDBService.getInstance().getByID(customerITN) != null) {
                        OrderingDBService.getInstance().add(new Ordering(
                                Integer.parseInt(req.getParameter("reference_number")),
                                customerITN,
                                req.getParameter("date")
                        ));
                    }
                }
                case 4 -> {
                    int type = Integer.parseInt(req.getParameter("type"));
                    CustomerDBService.getInstance().add(customerCreator(req, type));
                }
                case 5 -> OrderedItemDBService.getInstance().add(
                        Integer.parseInt(req.getParameter("order_ref_num")),
                        Integer.parseInt(req.getParameter("item_article"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/add?table=" + table);
    }

    private Customer customerCreator(HttpServletRequest req, int type) {
        return switch (type) {
            case 1 -> new LegalPerson(
                    req.getParameter("name"),
                    Integer.parseInt(req.getParameter("itn")),
                    req.getParameter("address")
            );
            case 2 -> new PrivatePerson(
                    req.getParameter("name"),
                    req.getParameter("birthdate"),
                    Integer.parseInt(req.getParameter("itn")),
                    req.getParameter("address")
            );
            default -> null;
        };
    }

    private Item itemCreator(HttpServletRequest req, int type) {
        return switch (type) {
            case 1 -> new Beam(
                    Integer.parseInt(req.getParameter("article")),
                    req.getParameter("title"),
                    req.getParameter("manufacturer"),
                    Integer.parseInt(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("length")),
                    Integer.parseInt(req.getParameter("width")),
                    Integer.parseInt(req.getParameter("height")),
                    req.getParameter("material")
            );
            case 2 -> new Fitting(
                    Integer.parseInt(req.getParameter("article")),
                    req.getParameter("title"),
                    req.getParameter("manufacturer"),
                    Integer.parseInt(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("length")),
                    Integer.parseInt(req.getParameter("thickness"))
            );
            case 3 -> new Pipe(
                    Integer.parseInt(req.getParameter("article")),
                    req.getParameter("title"),
                    req.getParameter("manufacturer"),
                    Integer.parseInt(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("inner_diameter")),
                    Integer.parseInt(req.getParameter("outer_diameter")),
                    req.getParameter("material")
            );
            default -> null;
        };
    }
}
