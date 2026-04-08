## Longest Common Subsequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

## Solution

How the DP Matrix Works in Longest Common Subsequence

The Concept

The algorithm uses a 2D table where dp[i][j] represents the length of the longest common subsequence between:

- First i characters of text1
- First j characters of text2

Example: text1 = "abcde", text2 = "ace"

          ""  a   c   e
      ""   0  0   0   0
      a    0  1   1   1
      b    0  1   1   1
      c    0  1   2   2
      d    0  1   2   2
      e    0  1   2   3

The Two Cases

Case 1: Characters Match (text1.charAt(i-1) == text2.charAt(j-1))
dp[i][j] = dp[i-1][j-1] + 1;

- Found a matching character! Add 1 to the LCS length from the previous diagonal cell
- This character contributes to the subsequence

Case 2: Characters Don't Match
dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

- Take the maximum from either:
  - Excluding current char from text1 (dp[i-1][j])
  - Excluding current char from text2 (dp[i][j-1])
- We're looking for the best LCS so far

Step-by-Step Walkthrough

Starting from i=1, j=1 (comparing 'a' from text1 with 'a' from text2):

i=1, j=1: 'a' == 'a' → dp[1][1] = dp[0][0] + 1 = 1 ✓ Match!
i=1, j=2: 'a' != 'c' → dp[1][2] = max(dp[0][2], dp[1][1]) = 1
i=1, j=3: 'a' != 'e' → dp[1][3] = max(dp[0][3], dp[1][2]) = 1

i=2, j=1: 'b' != 'a' → dp[2][1] = max(dp[1][1], dp[2][0]) = 1  
 i=2, j=2: 'b' != 'c' → dp[2][2] = max(dp[1][2], dp[2][1]) = 1
i=2, j=3: 'b' != 'e' → dp[2][3] = max(dp[1][3], dp[2][2]) = 1

i=3, j=1: 'c' != 'a' → dp[3][1] = max(dp[2][1], dp[3][0]) = 1
i=3, j=2: 'c' == 'c' → dp[3][2] = dp[2][1] + 1 = 2 ✓ Match!  
 i=3, j=3: 'c' != 'e' → dp[3][3] = max(dp[2][3], dp[3][2]) = 2

i=4, j=1: 'd' != 'a' → dp[4][1] = max(dp[3][1], dp[4][0]) = 1
i=4, j=2: 'd' != 'c' → dp[4][2] = max(dp[3][2], dp[4][1]) = 2  
 i=4, j=3: 'd' != 'e' → dp[4][3] = max(dp[3][3], dp[4][2]) = 2

i=5, j=1: 'e' != 'a' → dp[5][1] = max(dp[4][1], dp[5][0]) = 1
i=5, j=2: 'e' != 'c' → dp[5][2] = max(dp[4][2], dp[5][1]) = 2  
 i=5, j=3: 'e' == 'e' → dp[5][3] = dp[4][2] + 1 = 3 ✓ Match!

Final Result

dp[5][3] = 3 → The LCS is "ace" with length 3.

Why This Works

- We build solutions from smaller subproblems (bottom-up)
- Each cell represents the best answer for a subproblem
- By the time we reach dp[m][n], we've considered all possible subsequences
- Time: O(m × n) | Space: O(m × n)
