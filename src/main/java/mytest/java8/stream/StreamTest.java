package mytest.java8.stream;

import javafx.util.Pair;
import mytest.java8.stream.DemoModel.MemberBusinessTypeDO;
import mytest.java8.stream.DemoModel.MemberDo;
import mytest.java8.stream.DemoModel.Person;
import mytest.java8.stream.DemoModel.RoleDo;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-04 16:17
 **/
public class StreamTest {
    @Test
    public void testShowFunction() {
        String[] strs = new String[]{"a", "b", "c", "d", "e", "f", "b", "b", "b", "b", "b"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strs));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list2);

        new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        new TreeSet<String>((o1, o2) -> 0);

        lists.stream().map(new Function<List<String>, List<String>>() {
            @Override
            public List<String> apply(List<String> s) {
                return null;
            }
        });
        lists.stream().map((Function<List<String>, List<String>>) s -> null);

        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return null;
            }
        });
        list.stream().map(s -> null).collect(Collectors.toCollection(HashSet::new));
    }

    @Test
    public void testPeek1() {
        //peek可以在不创建新对象情况下，改变流中数据的引用值，从而修改list的数据
        //流式操作必须显示collect，否则就不会执行
        Person person1 = new Person();
        Person person2 = new Person();
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list = list.stream().peek(person -> person.setAge(1)).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testPeek2() {
        //peek可以在不创建新对象情况下，改变流中数据的引用值，从而修改list的数据
        //流式操作必须显示collect，否则就不会执行
        Map<String, Double> map = new HashMap<>();
        map.put("0-0", 12.7);
        Person person = new Person();
        person.setUnitPrice(map);
        List<Person> list = new ArrayList<>();
        list.add(person);
        System.out.println(person);

        list.stream().peek(person1 -> {
            Map<String, Double> unitPrice = person1.getUnitPrice();
            unitPrice.forEach((key, value) -> {
                unitPrice.put(key, (double) -1);
            });
        }).collect(Collectors.toList());
        System.out.println(person);
    }

    @Test
    public void testBigDecimal() {
        ArrayList<BigDecimal> bglist = new ArrayList<>();
        bglist.add(new BigDecimal(1));
        bglist.add(new BigDecimal(2));
        bglist.add(new BigDecimal(3));
        bglist.add(new BigDecimal(4));
        bglist.add(new BigDecimal(5));
        Optional<BigDecimal> reduce = bglist.stream().reduce(BigDecimal::add);
        Optional<BigDecimal> reduce2 = bglist.stream().reduce(BigDecimal::multiply);
    }

    @Test
    public void testIntStream() {
        IntStream intStream = Stream.of("1,2,3,4,5").mapToInt(Integer::parseInt);
        ArrayList<Integer> collect = intStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> list = intStream.boxed().collect(Collectors.toList());
    }
}
