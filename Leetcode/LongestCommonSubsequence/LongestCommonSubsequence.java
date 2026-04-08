package Leetcode.LongestCommonSubsequence;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    System.out.println(text1.charAt(i - 1) + "  ");
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        // Test case 1: Basic example
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Test 1: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 3\n");

        // Test case 2: No common subsequence
        text1 = "abc";
        text2 = "def";
        System.out.println("Test 2: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 0\n");

        // Test case 3: Identical strings
        text1 = "abc";
        text2 = "abc";
        System.out.println("Test 3: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 3\n");

        // Test case 4: One string is empty
        text1 = "";
        text2 = "abc";
        System.out.println("Test 4: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 0\n");

        // Test case 5: One string is subsequence of other
        text1 = "abc";
        text2 = "ahbgdc";
        System.out.println("Test 5: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 3\n");

        // Test case 6: Leetcode example
        text1 = "abcde";
        text2 = "ace";
        System.out.println("Test 6: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 3\n");

        // Test case 7: Longer strings
        text1 = "abcdefghij";
        text2 = "acegik";
        System.out.println("Test 7: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS length: " + lcs.longestCommonSubsequence(text1, text2));
        System.out.println("Expected: 5");
    }
}
