## 198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

## 213. House Robber II

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3

### Solution

House Robber - Logic Explained

This solves the classic House Robber problem where you can't rob adjacent houses, with an added twist: houses are arranged in a
circle (first and last are adjacent).

Main rob() Method (Line 4-8)

Since houses are in a circle, you have two exclusive choices:

1.  Rob from house 0 to n-2 (exclude the last house)
2.  Rob from house 1 to n-1 (exclude the first house)

                                                                                                                      ```

    return Math.max(
    robHelper(Arrays.copyOfRange(robs, 0, n - 1)), // exclude last  
     robHelper(Arrays.copyOfRange(robs, 1, n)) // exclude first
    );

```

The answer is the maximum of these two scenarios.

Helper robHelper() Method (Line 10-19)

This solves the linear version (no circular arrangement) using dynamic programming:

┌─────────────────┬──────────────────────────┐
│    Variable     │         Meaning          │
├─────────────────┼──────────────────────────┤
│ twoHousesBefore │ Max loot up to house i-2 │
├─────────────────┼──────────────────────────┤
│ previous        │ Max loot up to house i-1 ┤
└─────────────────┴──────────────────────────┘

At each house, you decide:
- Skip it: Take previous (best from house before)
- Rob it: Take robs[i] + twoHousesBefore (current + best from two houses back)

int bestChance = Math.max(previous, robs[i] + twoHousesBefore);

Then update: twoHousesBefore → previous → bestChance

Example with {1, 3, 1, 3, 100}

- Exclude last house [1,3,1,3] → Best = 1+3 = 4
- Exclude first house [3,1,3,100] → Best = 3+100 = 103
- Result = max(4, 103) = 103
```
