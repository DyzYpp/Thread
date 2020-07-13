package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestSleep
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 模拟倒计时
public class TestSleep2{
    public static void main(String[] args) {
//        tenDown();

        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown(){
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if (num <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
