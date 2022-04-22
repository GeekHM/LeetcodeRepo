package mytest.java.basic.compare;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-22 15:06
 * @version：
 **/
public class MyComparator {
    static ArrayList<Student> list = new ArrayList<>();

    static {
        list.add(new Student(1L, "zhao", 15, 99.0));
        list.add(new Student(2L, "qian", 14, 93.0));
        list.add(new Student(3L, "sun", 16, 95.0));
        list.add(new Student(4L, "li", 17, 97.0));
    }

    /**
     * 如果传了排序器，即使类有实现comparable接口，也是按排序器比较
     */
    @Test
    public void testCompare() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        list.sort(((o1, o2) -> o2.getAge() - o1.getAge()));

        list.sort(Student::compareTo);

        new TreeSet<>(Comparator.comparing(Student::getAge));

        System.out.println(list);
    }

    @Test
    public void streamTest() {
        list.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).collect(Collectors.toList());
    }

    @Test
    public void mapSortTest() {
        HashMap<Long, Student> map = new HashMap<>();
        map.put(1L, new Student(1L, "zhao", 15, 99.0));
        map.put(2L, new Student(2L, "qian", 14, 93.0));
        map.put(3L, new Student(3L, "sun", 16, 95.0));
        map.put(4L, new Student(4L, "li", 17, 97.0));
        new ArrayList<>(map.entrySet()).sort((o1, o2) -> (int) (o1.getKey() - o2.getKey()));

    }

    @Test
    public void test() {
        List<Integer> scoreList = getScoreList(13, 4);
        System.out.println(scoreList);
    }

    public static List<Integer> getScoreList(int total, int num) {
        int orderScore = total / num;
        int rest = total - orderScore * num;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(orderScore + rest - (rest > 0 ? --rest : 0));
        }
        return list;
    }
}
