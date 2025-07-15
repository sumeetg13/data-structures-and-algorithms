package Test;

import java.lang.reflect.Type;
import java.util.*;

class Test {
    public static void testify(java.util.Object actual, java.util.Object expected, Type type, String testName) {
        boolean isEqual = compare(actual, expected);

        if (isEqual) {
            System.out.println(testName + " - PASS");
        } else {
            System.out.println(testName + " - FAIL");
            System.out.println("Expected: " + toString(expected));
            System.out.println("Actual:   " + toString(actual));
        }
    }
    public static void testify(java.util.Object actual, java.util.Object expected, String testName) {
        boolean isEqual = compare(actual, expected);

        if (isEqual) {
            System.out.println(testName + " - PASS");
        } else {
            System.out.println(testName + " - FAIL");
            System.out.println("Expected: " + toString(expected));
            System.out.println("Actual:   " + toString(actual));
        }
    }
    private static boolean compare(java.util.Object a, java.util.Object b) {
        if (a instanceof int[] && b instanceof int[])
            return Arrays.equals((int[]) a, (int[]) b);
        if (a instanceof long[] && b instanceof long[])
            return Arrays.equals((long[]) a, (long[]) b);
        if (a instanceof double[] && b instanceof double[])
            return Arrays.equals((double[]) a, (double[]) b);
        if (a instanceof boolean[] && b instanceof boolean[])
            return Arrays.equals((boolean[]) a, (boolean[]) b);
        if (a instanceof Object[] && b instanceof Object[])
            return Arrays.deepEquals((Object[]) a, (Object[]) b);
        return Objects.equals(a, b);
    }
    private static String toString(java.util.Object obj) {
        if (obj instanceof int[])
            return Arrays.toString((int[]) obj);
        if (obj instanceof long[])
            return Arrays.toString((long[]) obj);
        if (obj instanceof double[])
            return Arrays.toString((double[]) obj);
        if (obj instanceof boolean[])
            return Arrays.toString((boolean[]) obj);
        if (obj instanceof Object[])
            return Arrays.deepToString((Object[]) obj);
        return String.valueOf(obj);
    }
}