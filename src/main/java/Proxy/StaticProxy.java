package Proxy;

/**
 * @ClassName StaticProxy
 * @Author
 * @Date 2020/7/13
 * @description
 */

// 静态代理模式
    // 真实对象和代理对象都要实现同一个接口
    // 代理对象必须代理真是角色
public class StaticProxy {
    public static void main(String[] args) {
        weddingCompany weddingCompany = new weddingCompany(new You());
        weddingCompany.HappyMarry();

        new Thread(() -> System.out.println("111")).start();

        new weddingCompany(new You()).HappyMarry();
    }
}


interface Marry{
    void HappyMarry();
}

// 真是角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("xxx结婚了");
    }
}


// 代理角色
class weddingCompany implements Marry{
        
    private Marry target;

    public weddingCompany(Marry target){
        this.target = target;
    }
    
    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚前,布置");
    }

    private void after() {
        System.out.println("结婚后,掏钱");
    }


}