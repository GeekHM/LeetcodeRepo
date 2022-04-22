package mytest.java.date;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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

    @Test
    public void test2() {
        //有业绩的年月日期集合：202202、202203
        HashSet<Integer> hasAchievementDateSet = new HashSet<>();
        hasAchievementDateSet.add(202204);
        hasAchievementDateSet.add(202202);
        hasAchievementDateSet.add(202107);

        //获取近十个月的日期集合:202202、202203、...、202107
        HashSet<Integer> allDateSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            LocalDate date = LocalDate.now().minusMonths(i);
            allDateSet.add(Integer.valueOf(date.getYear() + date.toString().substring(5, 7)));
        }

        allDateSet.removeAll(hasAchievementDateSet);
        System.out.println(allDateSet);
    }

    @Test
    public void test3() {
        Set<Long> selectSet = new HashSet<>();
        Set<Long> oldSet = new HashSet<>();
        Set<Long> newSet = new HashSet<>();

        selectSet.add(1L);
        selectSet.add(2L);
        selectSet.add(3L);
        selectSet.add(4L);
        selectSet.add(5L);

        oldSet.add(2L);
        oldSet.add(6L);
        oldSet.add(7L);
        oldSet.add(8L);

        newSet.addAll(selectSet);

        selectSet.removeAll(oldSet);

        System.out.println("selectSet" + selectSet);
        System.out.println("oldSet" + oldSet);
        System.out.println("newSet" + newSet);
    }

    @Test
    public void test4() {
        Set<Long> selectSet = new HashSet<>();
        Set<Long> oldSet = new HashSet<>();
        Set<Long> newSet = new HashSet<>();

        selectSet.add(1L);
        selectSet.add(2L);
//        selectSet.add(3L);
//        selectSet.add(4L);
//        selectSet.add(5L);
//        selectSet.add(6L);
//        selectSet.add(7L);
//        selectSet.add(8L);

        oldSet.add(1L);
        oldSet.add(2L);
        oldSet.add(6L);
//        oldSet.add(7L);
//        oldSet.add(8L);

        newSet.addAll(selectSet);

//        selectSet.removeAll(oldSet);
        System.out.println(setEqual(selectSet, oldSet));

        System.out.println("selectSet" + selectSet);
        System.out.println("oldSet" + oldSet);
        System.out.println("newSet" + newSet);
    }

    @Test
    public void test5(){
        List<Long> list1 = new ArrayList<>();
        Set<Long> list2 = null;
//        Set<Long> list2 = new HashSet<>();

        list1.add(1L);
        list1.add(2L);
        list1.add(3L);

//        list2.add(1L);
//        list2.add(2L);
//        list2.add(3L);

        System.out.println(setEqual(list1, list2));
    }

    public static boolean setEqual(Collection<Long> first, Collection<Long> second) {
        if (CollectionUtils.isEmpty(first) && CollectionUtils.isEmpty(second)) {
            return true;
        }

        if (CollectionUtils.isEmpty(first) && !CollectionUtils.isEmpty(second)) {
            return false;
        }

        if (!CollectionUtils.isEmpty(first) && CollectionUtils.isEmpty(second)) {
            return false;
        }

        if (first.size() != second.size()) {
            return false;
        }

        if (!first.stream().allMatch(f -> second.stream().anyMatch(s -> s.equals(f)))) {
            return false;
        }

        return second.stream().allMatch(s -> first.stream().anyMatch(f -> f.equals(s)));
    }
}
