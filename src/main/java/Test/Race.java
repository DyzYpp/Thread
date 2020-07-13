package Test;

/**
 * @ClassName Race
 * @Author
 * @Date 2020/7/13
 * @description
 */
// 模拟龟兔赛跑
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i + "步");

            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean b = gameOver(i);
            if (b) {
                break;
            }
        }

    }

    private boolean gameOver(int steps){
        if (winner != null){
            return true;
        }{
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName()+"是胜利者");
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
