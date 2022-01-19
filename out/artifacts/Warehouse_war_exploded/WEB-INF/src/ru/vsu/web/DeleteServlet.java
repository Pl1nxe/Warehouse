package ru.vsu.web;

import ru.vsu.database.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int table = Integer.parseInt(req.getParameter("table"));
        switch (table) {
            case 1 -> {
                WarehouseDBService.getInstance().removeByID(id);
                getServletContext().getRequestDispatcher("/warehouses.jsp").forward(req, resp);
            }
            case 2 -> {
                ItemDBService.getInstance().removeByID(id);
                getServletContext().getRequestDispatcher("/items").forward(req, resp);
            }
            case 3 -> {
                OrderingDBService.getInstance().removeByID(id);
                getServletContext().getRequestDispatcher("/orders.jsp").forward(req, resp);
            }
            case 4 -> {
                CustomerDBService.getInstance().removeByID(id);
                getServletContext().getRequestDispatcher("/customers.jsp").forward(req, resp);
            }
            case 5 -> {
                OrderedItemDBService.getInstance().remove(id);
                getServletContext().getRequestDispatcher("/ordered_items.jsp").forward(req, resp);
            }
            default -> getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}
