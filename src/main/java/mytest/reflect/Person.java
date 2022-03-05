package mytest.reflect;

/**
 * @description：
 * @author: whm
 * @create: 2022-02-09 08:47
 * @version：
 **/
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello MyReflection");
    }

    public void eat() {
        System.out.println("eating");
    }

    public void sleep() {
        System.out.println("sleeping");
    }

    public void helpIntroduce(String name, int age) {
        System.out.println("his name is" + name + ",his age is" + age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
