package Test;

/**
 * @ClassName TestThread3
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 创建线程的第二种方法,实现Runnable,重写Run方法,
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程"+i);
        }
        System.out.println("实现Runable接口创建线程");
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        Thread thread = new Thread(testThread3,"线程1");
        System.out.println(thread.getName());
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程"+i);
        }
    }
}
