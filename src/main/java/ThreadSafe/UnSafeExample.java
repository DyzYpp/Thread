package ThreadSafe;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @ClassName UnSafeExample
 * @Author
 * @Date 2020/7/15
 * @description
 */
public class UnSafeExample {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        Thread t1 = new Thread(buyTicket, "小明");
        Thread t2 = new Thread(buyTicket, "小红");
        Thread t3 = new Thread(buyTicket, "黄牛");

        t1.start();
        t2.start();
        t3.start();
    }

}

class BuyTicket implements Runnable {

    // 票数
    private int ticketNums = 10;

    // 通过标识位来停止线程
    boolean flag = true;

    @Override
    public void run() {
        while (flag == true) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "--->" + "第" + ticketNums-- + "张票");
    }
}