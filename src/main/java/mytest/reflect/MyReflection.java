package mytest.reflect;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.*;

/**
 * @description：
 * @author: whm
 * @create: 2022-02-09 08:34
 * @version：
 **/
public class MyReflection {
    /*
     * 获取class对象的三种方式
     */
    @Test
    public void myGetClass() throws ClassNotFoundException {
        //使用class的forName方法
        Class<?> personClass1 = Class.forName("mytest.reflect.Person");//需要加异常处理

        //使用类.class方法
        Class<Person> personClass2 = Person.class;

        //使用对象.getClass方法
        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();

        //使用ClassLoader
        ClassLoader classLoader = MyReflection.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("mytest.reflect.Person");
    }

    /*
     * 泛型编译后就是具体类型了，在运行时是具体类型
     */
    @Test
    public void usage() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("mytest.reflect.Person");
        System.out.println(class1.getName());

        Person person = new Person();
        Class<? extends Person> class2 = person.getClass();
        System.out.println(class1.getName());
    }

    /*
     * 创建对象
     */
    @Test
    public void usage2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        Class<Person> myClass = Person.class;
        //默认构造函数
        Person person = myClass.newInstance();
        //获取全部构造函数
        Constructor<?>[] constructors = myClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //指定构造函数
        Person person1 = myClass.getConstructor(String.class, int.class).newInstance("a", 14);
        System.out.println(person1);
    }

    /*
     * fields使用
     * declared是全部的，非declared是public的
     */
    @Test
    public void usage3() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> myClass = Person.class;

        //获取public的属性
        Field[] fields = myClass.getFields();
        Field field = myClass.getField("name");
        //获取所有的属性
        Field[] declaredFields = myClass.getDeclaredFields();
        Field declaredField = myClass.getDeclaredField("name");
        //获取名字与类型
        String name = field.getName();
        Class<?> type = field.getType();

        //获取权限
        int modifiers = field.getModifiers();
        String string = Modifier.toString(modifiers);

        //使用
        declaredField.setAccessible(true);//取消安全类型检查
        declaredField.set(new Person(), "aaa");
        Object o = declaredField.get(new Person());//获取的会是Object类型
    }

    /*
     * method使用
     * declared是全部的，非declared是public的
     */
    @Test
    public void usage4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> myClass = Person.class;

        //获取public的Method（包括父类）
        Method[] methods = myClass.getMethods();
        Method method = myClass.getMethod("setName", String.class);
        //获取当前类的所有方法（不包括父类）
        Method[] declaredMethods = myClass.getDeclaredMethods();
        Method declaredMethod = myClass.getDeclaredMethod("setName", String.class);

        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int modifiers = method.getModifiers();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Type genericReturnType = method.getGenericReturnType();

        //调用
        Object zhao = method.invoke("zhao");
    }

    /*
     * class继承关系
     */
    @Test
    public void usage5() {
        Class<Person> myClass = Person.class;

        //获取父类类型
        Class<? super Person> superclass = myClass.getSuperclass();
        //获取当前类实现的所有接口
        Class<?>[] interfaces = myClass.getInterfaces();
        //判断一个向上转型是否可以实现
        boolean assignableFrom = myClass.isAssignableFrom(String.class);

        //转换成子类
        Class<?> aClass = myClass.asSubclass(String.class);
    }

}
