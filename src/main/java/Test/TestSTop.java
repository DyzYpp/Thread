package Test;

import javax.swing.*;

/**
 * @ClassName TestSTop
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 建议线程正常停止,不建议死循环
    // 建议使用标志位,设置一个标志位
    // 不要使用stop或destroy等过时方法
public class TestSTop implements Runnable{

    // 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("---"+i++);
        }
    }

    public void stop(){
        this.flag = false;
        System.out.println("线程停止了");
    }

    public static void main(String[] args) {
        TestSTop testSTop = new TestSTop();
        new Thread(testSTop).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("+++"+ i);
            if (i == 88){
                testSTop.stop();
                break;
            }
        }
    }
}
