package ru.vsu.tools.builders;

public class OrderedItemHtmlFormBuilder {

    public static String getForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"order_ref_num\" placeholder=\"Order reference number\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"item_article\" placeholder=\"Item article\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"price\" placeholder=\"Price\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"count\" placeholder=\"Count\" required><br>");
        return stringBuilder.toString();
    }
}
