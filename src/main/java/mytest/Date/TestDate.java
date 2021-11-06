package mytest.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-06-22 16:04
 **/
public class TestDate {
    public static void main(String[] args) throws ParseException {
        String date = "2016/7/17 14:30:05";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date utilDate = null;
        utilDate = dateFormat.parse(date);
        System.out.println(utilDate);
//        try {
//            utilDate = dateFormat.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("utilDate: " + utilDate);
//
//        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf("2016-7-17 14:30:05");
//        java.sql.Date sqlDate = java.sql.Date.valueOf("2016-7-17");
//
//        System.out.println("sqlTimestamp: " + sqlTimestamp);
//        System.out.println("sqlDate: " + sqlDate);
    }
}
