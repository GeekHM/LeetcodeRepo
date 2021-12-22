package mytest.java8;

import mytest.java8.stream.DemoModel.Person;
import org.junit.Test;

import java.util.*;

/**
 * @description：
 * @author: whm
 * @create: 2021-11-25 11:07
 * @version：
 **/
public class OptionalDemo {
    /**
     * of不能传空，为空报异常
     * ofNullable可以传空
     * Optional中value为空时，只要get就报错
     */
    @Test
    public void test1() {
        Optional<Object> o = Optional.of(null);//报异常
        Optional<Object> o2 = Optional.ofNullable(null);//可以传空，但get时会报错
        Optional<String> empty = Optional.empty();//返回装着null的Optional，get会报错
        System.out.println();
    }

    /**
     * isPresent()  判断值是否存在
     * ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用
     */
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        Set<Person> peopleSet = new HashSet<>();
        Optional.of(new Person()).ifPresent(person -> personList.add(person));
        ;
        Optional.ofNullable(personList).ifPresent(peoplelist -> {
            peoplelist.stream().forEach(person -> peopleSet.add(person));
        });
        peopleSet.forEach(System.out::print);
    }

    /**
     * orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
     * orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
     */
    @Test
    public void test3() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        // orElse
        System.out.println(optional1.orElse(1000) == 1);// true
        System.out.println(optional2.orElse(1000) == 1000);// true

        // orElseGet
        System.out.println(optional1.orElseGet(() -> {
            return 1000;
        }) == 1);//true
        System.out.println(optional2.orElseGet(() -> {
            return 1000;
        }) == 1000);//true
    }

    /**
     * filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
     */
    @Test
    public void test4() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional1.filter(a -> a == null);
        Optional<Integer> filter2 = optional1.filter(a -> a == 1);
        Optional<Integer> filter3 = optional2.filter(a -> a == null);
        System.out.println(filter1.isPresent());// false
        System.out.println(filter2.isPresent());// true
        System.out.println(filter2.get().intValue() == 1);// true
        System.out.println(filter3.isPresent());// false
    }

    /**
     * map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
     */
    @Test
    public void test5() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
        Optional<String> str2Optional = optional2.map((a) -> "key" + a);

        System.out.println(str1Optional.get());// key1
        System.out.println(str2Optional.isPresent());// false

    }

    /**
     * flatMap()：功能与map()相似,区别在于mapping函数的返回值不同。
     * map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
     */
    @Test
    public void test6() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Optional<String>> str1Optional = optional1.map((a) -> {
            return Optional.<String>of("key" + a);
        });
        Optional<String> str2Optional = optional1.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });
        System.out.println(str1Optional.get().get());// key1
        System.out.println(str2Optional.get());// key1
    }
}
