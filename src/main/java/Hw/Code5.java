package Hw;

import java.util.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-08 23:13
 **/
/*
查找和排序

题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高

smith     67

jack      70

Tom       70
peter     96

注：0代表从高到低，1代表从低到高

本题含有多组输入数据！
输入描述：
输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开

输出描述：
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 */

/*
输入：
3
1
fang 90
yang 50
ning 70
3
0
moolgouua 43
aebjag 87
b 67
复制
输出：
yang 50
ning 70
fang 90
aebjag 87
b 67
moolgouua 43
复制
说明：
第一组用例:
3
1
fang 90
yang 50
ning 70
升序排序为：
yang 50
ning 70
fang 90
第二组降序为:
aebjag 87
b 67
moolgouua 43
 */
class Student {
    private String name;
    private int score;
    public static Comparator increase = new Increase();
    public static Comparator decrease = new Decrease();

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }

    private static class Increase implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.score - o2.score;
        }
    }

    private static class Decrease implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.score - o1.score;
        }
    }
}

public class Code5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Student[] students = new Student[num];
            int flag = sc.nextInt();
            for (int i = 0; i < num; i++) {
                Student student = new Student(sc.next(), Integer.valueOf(sc.next()));
                students[i] = student;
            }
            if (flag == 0) {
                Arrays.sort(students, Student.decrease);
            } else {
                Arrays.sort(students, Student.increase);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
