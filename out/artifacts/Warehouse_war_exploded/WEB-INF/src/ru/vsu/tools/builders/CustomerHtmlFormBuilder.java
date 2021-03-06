package ru.vsu.tools.builders;

import ru.vsu.customers.CustomerType;

public class CustomerHtmlFormBuilder {

    public static String getForm(CustomerType type) {
        if (type == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"itn\" placeholder=\"ITN\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"name\" placeholder=\"Name\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"address\" placeholder=\"Address\" required><br>");
        if (type == CustomerType.PRIVATE_PERSON)
            stringBuilder.append("<input type=\"date\" name=\"birthdate\" placeholder=\"Birthdate\" required><br>");
        stringBuilder.append("<input type=\"hidden\" name=\"type\" value=").append(type.getNum()).append(">");
        return stringBuilder.toString();
    }
}
