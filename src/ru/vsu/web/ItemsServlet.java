package ru.vsu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "items", urlPatterns = {"/items"})
public class ItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ItemDBService item = ItemDBService.getInstance();
//        List<Item> items = item.getAllFromDB();
//        req.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/items.jsp").forward(req, resp);
    }
}
