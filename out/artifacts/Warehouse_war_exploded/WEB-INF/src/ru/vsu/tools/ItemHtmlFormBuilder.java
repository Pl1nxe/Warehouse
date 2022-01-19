package ru.vsu.tools;

import ru.vsu.items.ItemType;

public class ItemHtmlFormBuilder {

    public static String getForm(ItemType type) {
        if (type == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"number\" placeholder=\"Warehouse number\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"article\" placeholder=\"Article\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"title\" placeholder=\"Title\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"manufacturer\" placeholder=\"Manufacturer\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"price\" placeholder=\"Price\" required><br>");
        switch (type) {
            case BEAM -> {
                stringBuilder.append("<input type=\"number\" name=\"length\" placeholder=\"Length\" required><br>");
                stringBuilder.append("<input type=\"number\" name=\"width\" placeholder=\"Width\" required><br>");
                stringBuilder.append("<input type=\"number\" name=\"height\" placeholder=\"Height\" required><br>");
                stringBuilder.append("<input type=\"text\" name=\"material\" placeholder=\"Material\" required><br>");
            }
            case FITTING -> {
                stringBuilder.append("<input type=\"number\" name=\"length\" placeholder=\"Length\" required><br>");
                stringBuilder.append("<input type=\"number\" name=\"thickness\" placeholder=\"Thickness\" required><br>");
            }
            case PIPE -> {
                stringBuilder.append("<input type=\"number\" name=\"inner_diameter\" placeholder=\"Inner diameter\" required><br>");
                stringBuilder.append("<input type=\"number\" name=\"outer_diameter\" placeholder=\"Outer diameter\" required><br>");
                stringBuilder.append("<input type=\"text\" name=\"material\" placeholder=\"Material\" required><br>");
            }
        }
        stringBuilder.append("<input type=\"hidden\" name=\"type\" value=").append(type.getNumber()).append(">");
        return stringBuilder.toString();
    }

}
