package com.ivanov;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

public class AppTests {

    AdultChecker adultChecker = new AdultChecker();

    @Test
    public void positiveTests() {
        boolean result = adultChecker.isAdult("2000.01.01");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1999 12 12");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1888/9.12");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1488*2*2");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1458*13*11");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1658*30*12");
        Assert.assertTrue(result);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);
        result = adultChecker.isAdult(cal.getTime());
        Assert.assertTrue(result);
    }

    @Test
    public void negativeTests() {
        boolean result = adultChecker.isAdult("2003.01.01");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2012 12 12");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2222/9.12");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2322*2*2");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2009*13*11");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2014*30*12");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("ascwevqw");
        Assert.assertFalse(result);
        result = adultChecker.isAdult(new Date());
        Assert.assertFalse(result);
        result = adultChecker.isAdult(null);
        Assert.assertFalse(result);
        result = adultChecker.isAdult("");
        Assert.assertFalse(result);
    }

    @Test
    public void dateParserTests() {
        DateParser dateParser = new DateParser();
        try {
            dateParser.parseObject(null);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Unable to parse the date: ");
        }
        try {
            dateParser.parseObject("asdfasdcqwec");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Unable to parse the date: asdfasdcqwec");
        }
        try {
            dateParser.parseObject(1);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')");
        }
    }

    @Test
    public void readDate() {
        try {
            FileReader.readerPatterns("asdf");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "asdf (The system cannot find the file specified)");
        }
    }
}
