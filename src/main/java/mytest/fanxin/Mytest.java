package mytest.fanxin;

import mytest.fanxin.model.Animal;
import mytest.fanxin.model.Cat;
import mytest.fanxin.model.MiniCat;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 10:12
 **/
public class Mytest {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();
        animals.add(new Animal("a"));
        animals.add(new Animal("b"));
        showAnimal(animals);
//        showAnimal(cats);
//        showAnimal(miniCats);
    }

    public static void showAnimal(ArrayList<? super Cat> list) {//只能传装着Cat和Cat父类对象的集合
//        list.add(new Animal());
        list.add(new Cat());
        list.add(new MiniCat());
        for (int i = 0; i < list.size(); i++) {
//            Object o = list.get(i);
            System.out.println(list.get(i));
        }
    }

//    public static void showAnimal2(ArrayList<?> list) {
//        list.add()
//    }

    @Test
    public void test() {//集合元素可以放自己和自己子类
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new MiniCat());
        animals.add(new Animal());

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new MiniCat());
//        cats.add(new Animal());//报错
    }


}
