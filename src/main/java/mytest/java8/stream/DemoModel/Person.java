package mytest.java8.stream.DemoModel;

import java.util.Map;
import java.util.Objects;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 17:23
 **/
public class Person {
    private String name;  // 姓名
    private Integer salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区
    private Map<String, Double> unitPrice;

    public Person() {
    }

    public Person(String name, Integer salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person(String name, Integer salary, int age, String sex, String area, Map<String, Double> unitPrice) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Map<String, Double> getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Map<String, Double> unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return salary == person.salary &&
                age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(area, person.area) &&
                Objects.equals(unitPrice, person.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age, sex, area, unitPrice);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
