package com.fengmi.mac_keeper;

import java.util.Calendar;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(calendar.getTime());
    }
}
