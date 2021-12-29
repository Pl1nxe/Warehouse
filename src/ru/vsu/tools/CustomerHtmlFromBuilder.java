package ru.vsu.tools;

import ru.vsu.customers.CustomerType;

public class CustomerHtmlFromBuilder {

    public static String getForm(CustomerType type) {
        if (type == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"number\" name=\"itn\" placeholder=\"ITN\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"name\" placeholder=\"Name\" required><br>");
        stringBuilder.append("<input type=\"text\" name=\"address\" placeholder=\"Address\" required><br>");
        if (type == CustomerType.PRIVATE_PERSON)
            stringBuilder.append("<input type=\"text\" name=\"birthdate\" placeholder=\"Birthdate\" required><br>");
        stringBuilder.append("<input type=\"hidden\" name=\"type\" value=").append(type.getNum()).append(">");
        return stringBuilder.toString();
    }
}
