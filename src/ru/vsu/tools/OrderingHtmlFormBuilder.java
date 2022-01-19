package ru.vsu.tools;

public class OrderingHtmlFormBuilder {

    public static String getForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"itn\" placeholder=\"ITN\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"name\" placeholder=\"Name\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"address\" placeholder=\"Address\" required><br>");
        return stringBuilder.toString();
    }
}
