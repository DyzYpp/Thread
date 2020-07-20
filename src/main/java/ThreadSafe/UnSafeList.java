package ThreadSafe;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName UnSafeList
 * @Author
 * @Date 2020/7/15
 * @description
 */
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 10000; i++) {
//            new Thread(() ->{
//                synchronized (list){
//                    list.add(Thread.currentThread().getName());
//                }
//            }).start();
//        }
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(list.size());

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(500);
        System.out.println(copyOnWriteArrayList.size());
    }
}
