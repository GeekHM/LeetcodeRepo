package mytest.fanxin.model;

/**
 * @description：
 * @author: whm
 * @create: 2022-02-10 19:50
 * @version：
 **/
public class PeopleGeneric<T> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
