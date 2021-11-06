package mytest.fanxin;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-05 10:09
 **/
public class MiniCat extends Cat {
    private String name;

    public MiniCat() {

    }

    public MiniCat(String name, String name1, String name2) {
        super(name, name1);
        this.name = name2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "name='" + name + '\'' +
                '}';
    }
}
