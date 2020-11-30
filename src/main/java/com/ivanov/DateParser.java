package com.ivanov;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateParser {

    private static final String PATTERNS_FILE_PATH = "formats.txt";

    public Date parseObject(Object object) {
        String[] patterns;
        Date date = null;
        try {
            patterns = FileReader.readerPatterns(PATTERNS_FILE_PATH);
            Object stringDate = validateObject(object);
            if (object instanceof Date)
                date = (Date) object;
            else
                date = DateUtils.parseDate((String) stringDate, patterns);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
