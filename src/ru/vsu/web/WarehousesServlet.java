package ru.vsu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "warehouses", urlPatterns = {"/warehouses"})
public class WarehousesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WarehouseDBService warehouse = WarehouseDBService.getInstance();
//        List<Warehouse> warehouses = warehouse.getAllFromDB();
//        req.setAttribute("warehouses", warehouses);
        getServletContext().getRequestDispatcher("/warehouses.jsp").forward(req, resp);
    }
}
