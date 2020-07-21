package Test;

/**
 * @ClassName DutyRead
 * @Author
 * @Date 2020/7/20
 * @description
 */
public class DutyRead {

    public static void main(String[] args) {
    Account account = new Account();
        try {
            new Thread(()->{
                account.set("zhangsan",100.0);
            }).start();
            Thread.sleep(1000);
            System.out.println(account.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
            System.out.println(account.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Account{

    private double balance;

    private String name;

    public synchronized  void set(String name,double balance){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized  double get(){
        return this.balance;
    }
}