package ru.vsu.tools.builders;

import ru.vsu.database.services.ItemDBService;
import ru.vsu.items.Item;
import ru.vsu.items.ItemType;

public class ItemHtmlFormBuilder {

    public static String getCompletedForm(Integer article) {
        Item item = ItemDBService.getInstance().getByID(article);
        int type = ItemDBService.getInstance().getType(article);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<p>Item article: " + item.getArticleNum() + "</p><br>");
        stringBuilder.append("<p>Title: </p><input type=\"text\" name=\"title\" value=\"" + item.getTitle() + "\" required><br>");
        stringBuilder.append("<p>Manufacturer: </p><input type=\"text\" name=\"manufacturer\" value=\"" + item.getManufacturer() + "\" required><br>");
        switch (type) {
            case 1 -> {
                stringBuilder.append("<p>Length: </p><input type=\"number\" name=\"length\" value=\"" + item.getLength() + "\" required><br>");
                stringBuilder.append("<p>Width: </p><input type=\"number\" name=\"width\" value=\"" + item.getWidth() + "\" required><br>");
                stringBuilder.append("<p>Height: </p><input type=\"number\" name=\"height\" value=\"" + item.getHeight() + "\" required><br>");
                stringBuilder.append("<p>Material: </p><input type=\"text\" name=\"material\" value=\"" + item.getMaterial() + "\" required><br>");
            }
            case 2 -> {
                stringBuilder.append("<p>Length: </p><input type=\"number\" name=\"length\" value=\"" + item.getLength() + "\" required><br>");
                stringBuilder.append("<p>Thickness: </p><input type=\"number\" name=\"thickness\" value=\"" + item.getThickness() + "\" required><br>");
            }
            case 3 -> {
                stringBuilder.append("<p>Inner diameter: </p><input type=\"number\" name=\"inner_diameter\" value=\"" + item.getInnerDiameter() + "\" required><br>");
                stringBuilder.append("<p>Outer diameter: </p><input type=\"number\" name=\"outer_diameter\" value=\"" + item.getOuterDiameter() + "\" required><br>");
                stringBuilder.append("<p>Material: </p><input type=\"text\" name=\"material\" value=\"" + item.getMaterial() + "\" required><br>");
            }
            default -> {
                return "<p>Error</p>";
            }
        }
        return stringBuilder.toString();
    }

    public static String getForm(ItemType type) {
        if (type == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"number\" placeholder=\"Warehouse number\" required><br>");
        stringBuilder.append("<input type=\"number\" name=\"article\" placeholder=\"Article\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"title\" placeholder=\"Title\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"manufacturer\" placeholder=\"Manufacturer\" required><br>");
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
