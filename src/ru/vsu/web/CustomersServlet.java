package ru.vsu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customers", urlPatterns = {"/customers"})
public class CustomersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CustomerDBService customer = CustomerDBService.getInstance();
//        CustomerDBService customer = (CustomerDBService) getServletContext().getAttribute("customer");
//        List<Customer> customers = customer.getAllFromDB();
//        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/customers.jsp").forward(req, resp);
    }
}
