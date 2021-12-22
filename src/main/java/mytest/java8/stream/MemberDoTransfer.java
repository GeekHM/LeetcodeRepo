package mytest.java8.stream;

import javafx.util.Pair;
import mytest.java8.stream.DemoModel.MemberBusinessTypeDO;
import mytest.java8.stream.DemoModel.MemberDo;
import mytest.java8.stream.DemoModel.Person;
import mytest.java8.stream.DemoModel.RoleDo;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-13 20:19
 * @version：
 **/
public class MemberDoTransfer {
    @Test
    public void testMemberDoTransfer() {
        //构造数据
        List<MemberDo> memberDoList = new ArrayList<>();
        HashSet<RoleDo> roleSet1 = new HashSet<>();
        HashSet<RoleDo> roleSet2 = new HashSet<>();
        MemberDo memberDo1 = new MemberDo(1L, roleSet1);
        MemberDo memberDo2 = new MemberDo(2L, roleSet2);
        roleSet1.add(new RoleDo(new MemberBusinessTypeDO(1L)));
        roleSet1.add(new RoleDo(new MemberBusinessTypeDO(2L)));
        roleSet1.add(new RoleDo(new MemberBusinessTypeDO(3L)));
        roleSet1.add(new RoleDo(new MemberBusinessTypeDO(4L)));
        roleSet2.add(new RoleDo(new MemberBusinessTypeDO(3L)));
        roleSet2.add(new RoleDo(new MemberBusinessTypeDO(4L)));
        memberDoList.add(memberDo1);
        memberDoList.add(memberDo2);
        System.out.println(memberDoList);

        //将数据拆成Map<Long,Set<Long>>
        Map<Long, Set<Long>> resMap = memberDoList.stream()
                .flatMap((Function<MemberDo, Stream<Pair>>) memberDoInList -> memberDoInList.getRoleDo()
                        .stream().map((Function<RoleDo, Pair<Long, Long>>) roleDo -> new Pair<>(memberDoInList.getId(), roleDo.getBusinessType().getId())))
                .collect(Collectors.groupingBy(pair -> (Long) pair.getKey(), Collectors.mapping(pair -> (Long) pair.getValue(), Collectors.toSet())));

        System.out.println(resMap);
    }

    //map的stream转换操作
    @Test
    public void testMapTransfer() {
        Map<Long, Pair<String, Long>> map = new HashMap<>();
        map.put(1L, new Pair<>("k1", 1L));
        map.put(2L, new Pair<>("k2", 2L));
        map.put(3L, new Pair<>("k3", 3L));
        Map<Long, Set<Long>> res = map.entrySet().stream()
                .map(entry -> new Pair(entry.getKey(), entry.getValue().getValue()))
                .collect(Collectors.groupingBy(pair -> (Long) pair.getKey()
                        , Collectors.mapping(downPair -> (Long) downPair.getValue(), Collectors.toSet())));
        System.out.println(res);
    }

    /*
     * 去重
     */
    @Test
    public void testDistinct() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Tom", 8900, 22, "man", "Fra"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        ArrayList<Person> list = personList.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getName() + ";" + o.getSalary()))), ArrayList::new));
        TreeMap<String, Set<String>> treeMap = personList.stream().collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getName() + ";" + o.getSalary()))), Collection::stream))
                .collect(Collectors.groupingBy(Person::getName, TreeMap::new, Collectors.mapping(person -> person.getArea() + "--" + person.getSex(), Collectors.toSet())));
        System.out.println(treeMap);

        personList.stream().filter(distinctByKey(Person::getName))
                .forEach(b -> System.out.println(b.getName() + "," + b.getArea()));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Test
    public void testCollectingAndThen() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Tom", 8900, 22, "man", "Fra"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        //查找工资最高的员工的姓名
        String userName = personList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getSalary)), (Optional<Person> person) -> person.map(Person::getName).orElse(null)));
        System.out.println(userName);
    }

    /*
     * 去重与排序
     * java中的排序器，返回0表示元素相等，返回1表示要交换，返回-1表示表不交换
     */
    @Test
    public void testCollectAndTreeSet() {
        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> Integer.compare(o2.getSalary(), o1.getSalary()));
//        TreeSet<Person> set = new TreeSet<>(Comparator.comparing(person -> person.getSalary() + person.getName()));
//        TreeSet<Person> set1 = new TreeSet<>(Comparator.comparing(new Function<Person, String>() {
//            @Override
//            public String apply(Person person) {
//                return person.getName() + person.getSalary();
//            }
//        }));
        treeSet.add(new Person("Tom", 8900, 23, "male", "New York"));
        treeSet.add(new Person("Tom", 8900, 22, "man", "Fra"));
        treeSet.add(new Person("Jack", 7000, 25, "male", "Washington"));
        treeSet.add(new Person("Lily", 7800, 21, "female", "Washington"));
        System.out.println(treeSet);
    }

    /*
     * findFirst查出空对象空指针处理
     * findFirst查的对象如果是null，则会报空指针，所以要在这一步操作前面加个filter操作，把所有的空给去掉
     * Stream是空的没事，像下面的例子，filter后求出的person对象的sex字段为空，然后又把这个属性map出来，最后又findFirst就会报错
     * 以后这种操作就把要求出的该属性为空的情况给先过滤掉
     */
    @Test
    public void testMapNull() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Tom", 8900, 22, null, "Fra"));
        personList.add(new Person("Jack", 7000, 25, null, "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        //错误写法
//        String res = personList.stream().filter(person -> person.getSalary() == 7000).map(Person::getSex).findFirst().orElse(null);

        //正确写法
        Person res = personList.stream().filter(person -> person.getSalary() == 7000 && StringUtils.hasLength(person.getSex())).findFirst().orElse(null);
        System.out.println(res);
    }
}
