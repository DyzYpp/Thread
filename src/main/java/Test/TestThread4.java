package Test;

/**
 * @ClassName TestThread4
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 多个线程同时操作同一个对象
// 购票
// 问题: 多个线程操作同一个资源对象,线程不安,数据紊乱
public class TestThread4 implements Runnable{

    private int nums = 10;

    @Override
    public void run() {
        while (true){
            if (nums <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----"+nums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 thread4 = new TestThread4();

        new Thread(thread4,"张三").start();
        new Thread(thread4,"李四").start();
        new Thread(thread4,"王五").start();
    }
}
