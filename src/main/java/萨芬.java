import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 萨芬
 * @Author
 * @Date 2020/7/21
 * @description
 */
public class 萨芬 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (int i = 0; i < 3; i++) {
            String str = list.get(list.size() -1);
            for (int i1 = list.size() - 1; i1 >= 0; i1--) {
                if (i1 != 0) {
                    list.set(i1, list.get(i1 - 1));
                }
            }
            list.set(0,str);
            System.out.println(list);
        }
    }
}
