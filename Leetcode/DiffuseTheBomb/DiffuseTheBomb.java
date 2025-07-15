package Leetcode.DiffuseTheBomb;
import java.util.Arrays;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if(k == 0){
            Arrays.fill(result, 0);
        }
        else if(k > 0){
            int windowSum = 0;
            for(int i=0; i<=k; i++){
                windowSum += code[i];
            }
            for(int i=0; i< code.length; i++){
                result[i] = windowSum - code[i];
                windowSum += code[(i+k+1)%code.length] - code[i];
            }
        }
        else{
            k = Math.abs(k);
            int windowSum = 0;
            for(int i=0; i<=k; i++){
                windowSum += code[i%code.length];
            }
            for(int i=k; i< code.length+k; i++){
                result[i%code.length] = windowSum - code[i%code.length];
                windowSum += code[(i+1)%code.length] - code[(i-k)%code.length];
            }
        }
        return result;
    }
     public static void main(String[] args) {
        Solution sol = new Solution();

        test(sol.decrypt(new int[]{5, 7, 1, 4}, 3), new int[]{12, 10, 16, 13}, "Test 1");
        test(sol.decrypt(new int[]{1, 2, 3, 4}, 0), new int[]{0, 0, 0, 0}, "Test 2");
        test(sol.decrypt(new int[]{2, 4, 9, 3}, -2), new int[]{12, 5, 6, 13}, "Test 3");
    }

    private static void test(int[] actual, int[] expected, String testName) {
        if (Arrays.equals(actual, expected)) {
            System.out.println(testName + " - PASS");
        } else {
            System.out.println(testName + " - FAIL");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
        }
    }
}
// O(N) time complexity
// O(N) space complexity
// Sliding window technique is used to calculate the sum of next k elements efficiently.