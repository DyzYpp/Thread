package Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @ClassName TestJoin
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 测试join方法  插队
public class TestJoin implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("---"+i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 50){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("+++"+i);
        }
    }
}

