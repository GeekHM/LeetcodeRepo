package mytest.fanxin.model;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 10:09
 **/
public class Cat extends Animal  {
    private String name;

    public Cat() {

    }

    public Cat(String name, String name1) {
        super(name);
        this.name = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }


}
