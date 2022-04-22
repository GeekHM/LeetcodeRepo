package mytest.thread.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static mytest.thread.java8.SmallTool.printTimeAndThread;
import static mytest.thread.java8.SmallTool.sleepMillis;

/**
 * @description：
 * @author: whm
 * @create: 2022-01-19 08:57
 * @version：
 **/
public class CompletableFutureDemo {
    /*
       1.校验交易流程
       2.检查商品信息
       3.检查会员信息
       4.全部检查成功后执行下单逻辑
       5.全部成功才下单成功，有一个失败就抛出异常
     */
    @Test
    public void test1() {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor();
        if(this.resultTest1()){
            printTimeAndThread("下单成功");
        }

    }

    public boolean resultTest1(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.get();
        printTimeAndThread("用户提交下单请求");
        List<CompletableFuture<String>> futures = new ArrayList<>();
        futures.add(verifyTransactionProc());
        futures.add(checkProductInfo());
        futures.add(checkMemberInfo());
        printTimeAndThread("正在校验中");
        CompletableFuture<Void> res = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .exceptionally(e -> {
                    printTimeAndThread(e.getMessage());
                    printTimeAndThread("下单失败");
                    return null;
                });
        CompletableFuture<List<String>> listCompletableFuture = res.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        List<String> join = listCompletableFuture.join();
        System.out.println(join);
        return  true;
    }

    @Test
    public void test2() {
        printTimeAndThread("用户提交下单请求");
        List<CompletableFuture<String>> futures = new ArrayList<>();
        futures.add(checkProductInfo());
        futures.add(checkMemberInfo());
        printTimeAndThread("正在校验中");
        CompletableFuture<Void> res = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .exceptionally(e -> {
                    printTimeAndThread(e.getMessage());
                    printTimeAndThread("下单失败");
                    return null;
                });
        CompletableFuture<Void> future = verifyTransactionProc().thenCompose(s -> res);
        printTimeAndThread("下单成功");
    }

    public CompletableFuture<String> verifyTransactionProc() {
        return CompletableFuture.supplyAsync(() -> {
            sleepMillis(1000);
            printTimeAndThread("校验交易流程");
            throw new RuntimeException("校验交易流程失败");
//            return "校验交易流程";
        });
    }

    public CompletableFuture<String> checkProductInfo() {
        return CompletableFuture.supplyAsync(() -> {
            sleepMillis(1000);
            printTimeAndThread("检查商品信息");
            return "检查商品信息";
        });
    }

    public CompletableFuture<String> checkMemberInfo() {
        return CompletableFuture.supplyAsync(() -> {
            sleepMillis(1000);
            printTimeAndThread("检查会员信息");
            return "检查会员信息";
        });
    }
}
