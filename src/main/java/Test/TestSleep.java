package Test;

/**
 * @ClassName TestSleep
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 模拟网络延时,放大问题的发生性
public class TestSleep implements Runnable {
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
