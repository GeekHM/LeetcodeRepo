package mytest.fanxin;

import mytest.fanxin.model.Wrapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
