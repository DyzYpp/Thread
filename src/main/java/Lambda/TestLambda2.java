package Lambda;

/**
 * @ClassName TestLambda
 * @Author
 * @Date 2020/7/13
 * @description
 */

// 函数式编程
public class TestLambda2 {

    public static void main(String[] args) {

     ILove  iLove = num -> {
         System.out.println("-----------"+num);
        };

        iLove.love(520);
    }
}


interface ILove{
    void love(int num);
}



