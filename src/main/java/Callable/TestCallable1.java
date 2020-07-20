package Callable;

import java.util.concurrent.*;

/**
 * @ClassName TestThread1
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 可以接受返回值
public class TestCallable1 implements Callable<Boolean> {
    private String name;

    public TestCallable1(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable1 testThread1 = new TestCallable1("张三");
        TestCallable1 testThread2 = new TestCallable1("李四");
        TestCallable1 testThread3 = new TestCallable1("王五");

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> submit = executorService.submit(testThread1);
        Future<Boolean> submit1 = executorService.submit(testThread2);
        Future<Boolean> submit2 = executorService.submit(testThread3);

        // 三个线程的执行顺序由cpu调度安排,人为无法干预
        Boolean aBoolean = submit.get();
        Boolean aBoolean1 = submit1.get();
        Boolean aBoolean2 = submit2.get();

        System.out.println(aBoolean);
        System.out.println(aBoolean1);
        System.out.println(aBoolean2);

        executorService.shutdown();
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(name);
        return true;
    }
}
