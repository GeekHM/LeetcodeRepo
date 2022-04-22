package mytest.java.basic.compare;

import lombok.Data;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-22 15:05
 * @version：
 **/
@Data
public class Student implements Comparable<Student> {
    private Long id;
    private String name;
    private Integer age;
    private Double score;

    public Student(Long id, String name, Integer age, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
