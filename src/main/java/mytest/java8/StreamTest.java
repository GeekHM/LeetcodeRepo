package mytest.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-04 16:17
 **/
public class StreamTest {
    public static void main(String[] args) {
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
        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return null;
            }
        });
        lists.stream().map((Function<List<String>, List<String>>) s -> null);
        list.stream().map(s -> null);
    }
}
