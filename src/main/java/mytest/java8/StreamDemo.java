package mytest.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 17:22
 **/
public class StreamDemo {
    public static List<Person> personList = new ArrayList<Person>();

    static {
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
    }

    /**
     * 从员工集合中筛选出salary大于8000的员工，并放置到新的集合里。
     */
    public void test1() {
        List<Person> list = personList.stream().filter(person -> person.getSalary() > 8000).collect(Collectors.toList());
    }

    /**
     * 统计员工的最高薪资、平均薪资、薪资之和。
     */
    public void test2() {
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        Optional<Person> max2 = personList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getSalary)));
    }

    /**
     * 将员工按薪资从高到低排序，同样薪资者年龄小者在前。
     */
    @Test
    public void test3() {
        List<Person> list = personList.stream()
                .sorted((o1, o2) -> o1.getSalary() == o2.getSalary() ? o1.getAge() - o2.getAge() : o2.getSalary() - o1.getSalary())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * 将员工按性别分类，将员工按性别和地区分类，将员工按薪资是否高于8000分为两部分。
     */
    @Test
    public void test4() {
//        Map<Object, Map<Object, List<Person>>> map = personList.stream()
//                .collect(Collectors.groupingBy(person -> person.getSalary() > 8000, Collectors.groupingBy(person -> person.getAge() > 15)));
//        personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting())).forEach((s, aLong) -> System.out.println(s+" "+aLong));
//        Map<String, List<Person>> map1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(person -> {
            return "" + person.getSex() + person.getArea();
        }));
        collect.forEach((s, people) -> System.out.println(s + "  " + people));

        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
    }
}
