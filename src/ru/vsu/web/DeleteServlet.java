package ru.vsu.web;

import ru.vsu.items.Item;
import ru.vsu.services.db.ItemDBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ItemDBService item = (ItemDBService) getServletContext().getAttribute("item");
        if (id != null)
            item.removeByID(Integer.parseInt(id));
        List<Item> items = item.getAllFromDB();
        req.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/delete.jsp").forward(req, resp);
    }
}
