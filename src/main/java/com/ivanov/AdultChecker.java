package com.ivanov;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class AdultChecker {

    private final static int age = 18;
    private static final DateParser dateParser = new DateParser();

    public boolean isAdult(Object object) {
        Date currentDate = null;
        try {
            currentDate = dateParser.parseObject(object);
        } catch (ParseException | IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
        return currentDate != null && currentDate.compareTo(getAgeDate()) < 0;
    }


    private Date getAgeDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age);
        return cal.getTime();
    }

}
