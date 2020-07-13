package Test;

/**
 * @ClassName TestThread1
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 集成Thread类  通过调用线程类对象的Start方法启动线程
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程"+i);
        }
    }

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程"+i);
        }
    }
}
