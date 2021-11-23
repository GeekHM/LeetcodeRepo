package mytest.java8;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-08 10:29
 **/
public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<String> manArray = new ArrayList<>();
        manArray.add("刘德华");
        manArray.add("成龙");
        manArray.add("吴彦祖");
        manArray.add("周润发");
        manArray.add("周星驰");
        manArray.add("吴京");

        ArrayList<String> womanList = new ArrayList<>();
        womanList.add("林心如");
        womanList.add("孙俪");
        womanList.add("柳岩");
        womanList.add("林青霞");
        womanList.add("王祖贤");
        womanList.add("张曼玉");
        /**
         * 男演员只要名字为3个字的前三人
         * 女演员只要姓林的，并且不要第一个
         * 把过滤后的男演员姓名和女演员姓名合并到一起
         * 把上一步操作后的元素作为构造方法的参数创建演员对象（实例化一个Actor类，此处尝试使用map），遍历数组
         */

        //womanList.stream().filter(s -> s.startsWith("林")).skip(1);
        //男演员只要名字为3个字的前三人
        //Stream<String> manStream = manArray.stream().filter(s -> s.length() == 3).limit(3);
        //把过滤后的男演员姓名和女演员姓名合并到一起
        //Stream<String> stream = Stream.concat(manStream, womanStream);
        //把上一步操作后的元素作为构造方法的参数创建演员对象,遍历数据
        //stream.map(Actor::new).forEach(System.out::println);
        //stream.map(Actor::new).forEach(p -> System.out.println(p.getName()));
        Stream.concat(manArray.stream().filter(s -> s.length() == 3).limit(3),
                womanList.stream().filter(s -> s.startsWith("林")).skip(1)).map(Actor::new).
                forEach(p -> System.out.println(p.getName()));
    }

    static class Actor {
        private String name;

        public Actor() {
        }

        public Actor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
