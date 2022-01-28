package ru.vsu.tools.builders;

public class OrderingHtmlFormBuilder {

    public static String getForm(int type) {
        StringBuilder stringBuilder = new StringBuilder();
        if (type == 2)
            stringBuilder.append("<input type=\"number\" name=\"itn\" placeholder=\"Customer ITN\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"order_ref_num\" placeholder=\"Order reference number\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"item_article\" placeholder=\"Item article\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"warehouse_num\" placeholder=\"Warehouse number\" required><br>");
        return stringBuilder.toString();
    }
}
