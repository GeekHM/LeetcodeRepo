package mytest.reflect.staticProxy;

/**
 * @description：
 * @author: whm
 * @create: 2022-02-13 20:29
 * @version：
 **/
interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂的一些前置工作");

        clothFactory.produceCloth();

        System.out.println("代理工厂的一些后置工作");
    }
}

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产衣服");
    }
}

public class MyStaticProxy {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
