package ru.vsu.web;

import ru.vsu.items.*;
import ru.vsu.services.db.ItemDBService;
import ru.vsu.tools.ItemHtmlFormBuilder;

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
        String typeString = req.getParameter("type");
        ItemType type = (typeString != null) ? ItemType.getTypeFromTypeNumber(Integer.parseInt(typeString)) : null;
        String form = (type != null) ? ItemHtmlFormBuilder.getForm(type) : null;
        ItemType[] types = ItemType.values();
        req.setAttribute("form", form);
        req.setAttribute("type", type);
        req.setAttribute("types", types);
        getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        Item item = switch (Integer.parseInt(type)) {
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
        if (item == null) return;
        ItemDBService items = (ItemDBService) getServletContext().getAttribute("items");
        items.add(item);
        resp.sendRedirect(getServletContext().getContextPath() + "/add");
    }
}
