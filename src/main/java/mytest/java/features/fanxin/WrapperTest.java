package mytest.java.features.fanxin;

import mytest.java.features.fanxin.model.Wrapper;
import org.junit.Test;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-20 15:57
 * @version：
 **/
public class WrapperTest {
    @Test
    public void test() {
        Wrapper<Double> wrapper = new Wrapper<>();
        Wrapper<Object> success = Wrapper.success();
        Wrapper<String> aaa = Wrapper.success("aaa");
    }
}
