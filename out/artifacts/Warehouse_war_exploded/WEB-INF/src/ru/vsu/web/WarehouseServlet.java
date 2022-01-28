package ru.vsu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "warehouse", urlPatterns = {"/warehouse"})
public class WarehouseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        if (number != null) {
            req.setAttribute("number", Integer.parseInt(number));
            getServletContext().getRequestDispatcher("/warehouse.jsp").forward(req, resp);
        }
    }
}
