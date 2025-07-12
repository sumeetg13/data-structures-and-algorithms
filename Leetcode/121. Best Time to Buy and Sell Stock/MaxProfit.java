
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}

class MaxProfitTest {
    public static void main(String[] args) {

        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        int expected1 = 5;
        runTest(prices1, expected1, "Test 1");

        int[] prices2 = { 7, 6, 4, 3, 1 };
        int expected2 = 0;
        runTest(prices2, expected2, "Test 2");
    }

    private static void runTest(int[] prices, int expected, String testName) {
        MaxProfit sol = new MaxProfit();
        int actual = sol.maxProfit(prices);
        String result = actual == expected ? "PASS" : "FAIL";
        System.out.println(testName + ": " + result + " | Expected: " + expected + ", Actual: " + actual);
    }
}