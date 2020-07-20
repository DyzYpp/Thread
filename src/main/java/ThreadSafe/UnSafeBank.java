package ThreadSafe;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

/**
 * @ClassName UnSafeBank
 * @Author
 * @Date 2020/7/15
 * @description
 */
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(500, "建行余额");
        Bank bank = new Bank(account, 100, "女友");
        Bank bank1 = new Bank(account, 200, "我");
        bank.start();
        bank1.start();
    }
}

class Account {
    int money;
    String accountName;

    public Account(int money, String accountName) {
        this.money = money;
        this.accountName = accountName;
    }
}

class Bank extends Thread {

    Account account;

    int takeMoney;

    public Bank(Account account, int takeMoney, String name) {
        super(name);
        this.account = account;
        this.takeMoney = takeMoney;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.money - takeMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "卡内余额不足!!!");
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - takeMoney;
            System.out.println(this.getName() + "有" + takeMoney);
            System.out.println(account.accountName + ":" + account.money);
        }
    }
}