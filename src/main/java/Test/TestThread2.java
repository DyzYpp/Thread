package Test;

/**
 * @ClassName TestThread1
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 线程不是启动后就会立即执行, 而是由CPU调度
public class TestThread2 extends Thread {

    private String name;

    public TestThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {

        TestThread2 testThread1 = new TestThread2("张三");
        TestThread2 testThread2 = new TestThread2("李四");
        TestThread2 testThread3 = new TestThread2("王五");
        // 三个线程的执行顺序由cpu调度安排,人为无法干预
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}
