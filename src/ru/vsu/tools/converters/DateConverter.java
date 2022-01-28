package ru.vsu.tools.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static DateConverter INSTANCE;

    public static DateConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DateConverter();
        }
        return INSTANCE;
    }

    public Calendar fromString(String strDate) {
        Calendar date;
        if (strDate == null){
            date = null;
        } else {
            try {
                Date parsed = format.parse(strDate);
                date = new GregorianCalendar();
                date.setTime(parsed);
            } catch (ParseException e) {
                e.printStackTrace();
                date = null;
            }
        }
        return date;
    }

    public String toString(Calendar date) {
        return date.toString();
    }
}
