package ru.vsu.tools;

public class WarehouseHtmlFormBuilder {

    public static String getForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"number\" placeholder=\"Number\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"address\" placeholder=\"Address\" required><br>");
        return stringBuilder.toString();
    }
}
