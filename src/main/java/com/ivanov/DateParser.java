package com.ivanov;

import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class DateParser {

    public Date parseObject(Object object) throws IOException, ParseException {
        String[] patterns = FileReader.readerPatterns("formats.txt");
        Date date;
        try {
            Object stringDate = validateObject(object);
            if (object instanceof Date)
                date = (Date) object;
            else
                date = DateUtils.parseDate((String) stringDate, patterns);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return date;
    }

    private Object validateObject(Object object) {
        if (object == null || object.toString().isEmpty())
            return "";
        else if (object instanceof String)
            return ((String) object).replaceAll("[-+.^*:#@!&()_=, /]", "-");
        else return object;
    }
}
