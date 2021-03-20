package SortAlgos;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void test(Class<?> sortClass) {
        Method[] methods = sortClass.getMethods();
        for (int i = 10; i < 50; i+=5) {
            for (int k = 0; k < 3; k++) {
                Integer[] testArray = integerArrayGen(i);
                Integer[] testArrayBackUp = testArray.clone();
                Method ourMethod = methods[0];
                for (Method m : methods) {
                    if (m.getName().matches("\\w+ort")) {
                        ourMethod = m;
                        break;
                    }
                }
                try {
                    Object[] args = {testArray};
                    Object resultObject = ourMethod.invoke(sortClass.getDeclaredConstructor().newInstance(), args);
                    if (resultObject.getClass().isArray()) {
                        int length = Array.getLength(resultObject);
                        if (length != testArrayBackUp.length) {
                            System.err.println("Result length incorrect, have: " + length +
                                    ", but should be: " + testArrayBackUp.length);
                            return;
                        }
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
                                    System.out.print(Array.get(resultObject, l).toString());
                                }
                                System.out.print("]");
                                return;
                            }

                        }
                        System.out.println("Test Array:");
                        System.out.println(Arrays.toString(testArrayBackUp));
                        System.out.println("Full result check: ");
                        System.out.print("[");
                        for (int l = 0; l < length - 1; l++) {
                            System.out.print(Array.get(resultObject, l).toString() + ", ");
                        }
                        System.out.print(Array.get(resultObject, length - 1).toString());
                        System.out.print("]");
                        System.out.println("\n");
                    }
                    else
                        System.out.println(resultObject.getClass());
                } catch (Exception e) {
                    System.out.println("Exceptions: " + e);
                    return;
                }

            }
        }
        System.out.println("All good");
    }

    public static Integer[] integerArrayGen(Integer length) {
        Random rand = new Random();
        Integer[] testArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = rand.nextInt(100);
        }
        return testArray;
    }
}
