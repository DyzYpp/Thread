package Test;

/**
 * @ClassName TestYield
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 礼让线程
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println("开始执行"+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("执行结束"+Thread.currentThread().getName());
    }
}
