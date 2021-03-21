import java.util.Arrays;
import java.util.Random;
import java.lang.*;

public class Test {
    protected void test(int k) {
        Random rand = new Random();
        Integer[] a1 = new Integer[10];
        Integer[] a2 = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a1[i] = rand.nextInt(100);
        }
        for (int i = 0; i < 10; i++) {
            a2[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    public static void main (String[] args) {
        System.out.println(3/2);
    }
}
