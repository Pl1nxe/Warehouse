package ru.vsu.web;

import ru.vsu.order.Order;
import ru.vsu.services.db.OrderingDBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orders", urlPatterns = {"/orders"})
public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        OrderingDBService ordering = OrderingDBService.getInstance();
        OrderingDBService ordering = (OrderingDBService) getServletContext().getAttribute("ordering");
        List<Order> orders = ordering.getAllFromDB();
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/orders.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
