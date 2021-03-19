package SortAlgos;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void test(Class<?> sortClass) {
        Method[] methods = sortClass.getMethods();
        for (int i = 10; i < 30; i+=5) {
            for (int k = 0; k < 3; k++) {
                Integer[] testArray = arrayGen(i);
                Integer[] testArrayBackUp = testArray.clone();
                Object resultObject = new Object();
                for (Method m : methods) {
                    if (m.getName().matches("Sort")) {
                        try {
                            resultObject = m.invoke(sortClass.getDeclaredConstructor().newInstance(), testArray);
                        } catch (Exception e) {
                            System.out.println("Exception: " + e);
                            return;
                        }
                        break;
                    }
                }
                if (resultObject.getClass().isArray()) {
                    int length = Array.getLength(resultObject);
                    for (int j = 0; j < length - 1; j++) {
                        String left = Array.get(resultObject, j).toString();
                        String right = Array.get(resultObject, j + 1).toString();
                        int leftInt = Integer.parseInt(left);
                        int rightInt = Integer.parseInt(right);
                        if (leftInt > rightInt) {
                            System.out.println("Result fault at position " + i + (i+1) + "in test sample:");
                            System.out.println(Arrays.toString(testArrayBackUp));
                            System.out.println("Full result check: ");
                            System.out.print("[");
                            for (int l = 0; l < length; l++) {
                                System.out.print(Array.get(resultObject, j + 1).toString());
                            }
                            System.out.print("]");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("All good");
    }

    private static Integer[] arrayGen(Integer length) {
        Random rand = new Random(47);
        Integer[] testArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = rand.nextInt();
        }
        return testArray;
    }
}
