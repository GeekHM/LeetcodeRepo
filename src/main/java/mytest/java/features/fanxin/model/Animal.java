package mytest.java.features.fanxin.model;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 10:09
 **/
public class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
