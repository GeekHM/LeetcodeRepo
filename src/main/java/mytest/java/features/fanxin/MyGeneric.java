package mytest.java.features.fanxin;

import mytest.java.features.fanxin.model.Animal;
import mytest.java.features.fanxin.model.Cat;
import mytest.java.features.fanxin.model.MiniCat;
import mytest.java.features.fanxin.model.PeopleGeneric;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 10:12
 **/
public class MyGeneric {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();
        animals.add(new Animal("a"));
        animals.add(new Animal("b"));
    }

    /*
     * super可以放数据进集合，但只能放T及其子类
     * 可以取数据出来，但取出来是Object
     */
    public static void showAnimal(ArrayList<? super Cat> list) {//只能传装着Cat和Cat父类对象的集合
//        list.add(new Animal()); 报错  只能放子类
        list.add(new Cat());
        list.add(new MiniCat());
        Object object = list.get(0);//取出来是Object类型
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /*
     * extends可以取数据出来，类型为T
     * 不能放数据进去
     */
    public static void showAnimal2(ArrayList<? extends Animal> list) {
        Animal animal = list.get(0);//取出来是Animal类型
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /*
     * ？情况下，取出来都是Object，不能放
     * 不能放数据进去
     */
    public static void show(ArrayList<?> list) {
        System.out.println(list);
        Object o = list.get(0);
//        list.add("a");  报错
    }

    /*
     * PECS原则，extends可以取，super可以存
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }

    /*
     * 集合元素可以放自己和自己子类
     */
    @Test
    public void test() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new MiniCat());
        animals.add(new Animal());

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new MiniCat());
//        cats.add(new Animal());//报错
    }

    /*
     * 泛型擦除
     */
    @Test
    public void test2() {
        PeopleGeneric<String> generic1 = new PeopleGeneric<>();
        PeopleGeneric<Integer> generic2 = new PeopleGeneric<>();
        String name1 = generic1.getName();
        Integer name2 = generic2.getName();
        System.out.println((generic1.getClass() == generic2.getClass()));
    }
}
