package mytest;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-07-13 22:25
 * A
 * B
 * C
 **/
public class TestInstanceof {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println("a instanceof A:"+ (a instanceof A));
        System.out.println("a instanceof B:"+ (a instanceof B));
        System.out.println("a instanceof C:"+ (a instanceof C));

        System.out.println("b instanceof A:"+ (b instanceof A));
        System.out.println("b instanceof B:"+ (b instanceof B));
        System.out.println("b instanceof C:"+ (b instanceof C));

        System.out.println("c instanceof A:"+ (c instanceof A));
        System.out.println("c instanceof B:"+ (c instanceof B));
        System.out.println("c instanceof C:"+ (c instanceof C));
    }
}

class A {

}

class B extends A {

}

class C extends B {

}