package Lambda;

import java.util.jar.JarInputStream;

/**
 * @ClassName TestLambda
 * @Author
 * @Date 2020/7/13
 * @description
 */

// 函数式编程
public class TestLambda {

    // 静态内部类
    static class like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike iLike = new like();
        iLike.lambda();

        iLike = new like2();
        iLike.lambda();

        // 局部内部类
        class like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like Lambda3");
            }
        }
        iLike = new like3();
        iLike.lambda();

        // 匿名内部类
        iLike = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4");
            }
        };
        iLike.lambda();

        // lambda
        iLike = () -> {
            System.out.println("I like Lambda5");
        };
        iLike.lambda();

    }
}

interface ILike {
    void lambda();
}

class like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like Lambda");
    }
}
