package com.ivanov;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

public class AppTests {

    AdultChecker adultChecker = new AdultChecker();

    @Test
    public void positiveTests() {
        boolean result = adultChecker.isAdult("2000.01-01");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1999+12 12");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1888^9.12");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1488:2*2");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1458#13@11");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("1658!30&12");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("2001(07)04 12:08:56");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("2001_07=04 12:08:56.235-0700");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("2001,W27-3");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("02001.July.04 AD 12:08 PM");
        Assert.assertTrue(result);
        result = adultChecker.isAdult("0:08 PM,PDT");
        Assert.assertTrue(result);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);
        result = adultChecker.isAdult(cal.getTime());
        Assert.assertTrue(result);
    }

    @Test
    public void negativeTests() {
        boolean result = adultChecker.isAdult("2005.01-01");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2014+1 1");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2888^9.12");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2488:2*2");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2458#13@11");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2658!30&12");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("ascwevqw");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2011-07-04 12:08:56");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2011-07-04 12:08:56.235-0700");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("2011-W27-3");
        Assert.assertFalse(result);
        result = adultChecker.isAdult("02011.July.04 AD 12:08 PM");
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
