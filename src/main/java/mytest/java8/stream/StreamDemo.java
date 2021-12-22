package mytest.java8.stream;

import javafx.util.Pair;
import mytest.java8.stream.DemoModel.Person;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 17:22
 **/
public class StreamDemo {
    public static List<Person> personList = new ArrayList<Person>();

    static {
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Tom2", 10000, 21, "male", "China"));//
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
//        List<String> collect = personList.stream().filter(person -> person.getSalary() > 8000).collect(Collectors.mapping(Person::getName, Collectors.toList()));
        List<String> collect = personList.stream().filter(person -> person.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        List<Person> list = personList.stream().filter(person -> person.getSalary() > 8000).collect(Collectors.toList());
    }

    /**
     * 统计员工的最高薪资、平均薪资、薪资之和。
     */
    public void test2() {
        Optional<Person> max2 = personList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getSalary)));
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        OptionalDouble average = personList.stream().mapToDouble(Person::getSalary).average();
        int sum = personList.stream().mapToInt(Person::getSalary).sum();
        Optional<Integer> reduce = personList.stream().map(Person::getSalary).reduce(Integer::sum);
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
        //按性别分
        Map<String, List<Person>> map1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        //按性别:数量来分
        personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting())).forEach((s, aLong) -> System.out.println(s + " " + aLong));
        //先按薪水分一个集合，分完后再按年龄分一个集合
        Map<Object, Map<Object, List<Person>>> map = personList.stream().collect(Collectors.groupingBy(person -> person.getSalary() > 8000, Collectors.groupingBy(person -> person.getAge() > 15)));
        //先按性别分一个集合，分完后再按区域分一个集合
        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        //按性别和区域分(String)
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(person -> {
            return "" + person.getSex() + person.getArea();
        }));
        collect.forEach((s, people) -> System.out.println(s + "  " + people));
        //按性别和区域分(pair)
        Map<Pair, List<Person>> collect2 = personList.stream().collect(Collectors.groupingBy(person -> new Pair(person.getSex(), person.getArea())));
        //把结果做成不同的集合返回
        Map<String, Set<Person>> collect3 = personList.stream().collect(Collectors.groupingBy(person -> person.getArea(), Collectors.toSet()));
        Map<String, Map<String, Integer>> collect4 = personList.stream().collect(Collectors.groupingBy(Person::getArea, Collectors.toMap(Person::getName, Person::getAge)));
        collect4.forEach((s, people) -> System.out.println(s + "  " + people));
    }

    /**
     * 将员工的薪资全部增加1000。
     */
    @Test
    public void test5() {
        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        // 改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        System.out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());
    }

    /**
     * 求所有员工的工资之和和最高工资。
     */
    @Test
    public void test6() {
        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }
}
