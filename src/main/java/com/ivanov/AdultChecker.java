package com.ivanov;

import java.util.Calendar;
import java.util.Date;

public class AdultChecker {

    private final static int AGE = 18;
    private static final DateParser dateParser = new DateParser();

    public boolean isAdult(Object object) {
        Date currentDate = dateParser.parseObject(object);
        return currentDate != null && currentDate.compareTo(getAgeDate()) < 0;
    }


    private Date getAgeDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -AGE);
        return cal.getTime();
    }

}
