package Leetcode.RottingOranges;

import java.util.*;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int minutes = 0;
        // bfs
        while (!q.isEmpty() && fresh > 0) {
            // parellel processing of all 2(rotten) oranges
            minutes++;
            for (int i = 0; i < q.size(); i++) {
                int[] current = q.poll();
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[] { x, y });
                    }
                }
            }

        }
        if (fresh > 0) {
            return -1;
        }
        return minutes;
    }
}

class RottingOrangesTest {
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();

        int[][] grid1 = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println("Test 1: " + (ro.orangesRotting(grid1) == 4 ? "PASS" : "FAIL"));

        int[][] grid2 = {
                { 2, 2, 2 },
                { 2, 2, 2 }
        };
        System.out.println("Test 2: " + (ro.orangesRotting(grid2) == 0 ? "PASS" : "FAIL"));

        int[][] grid3 = {
                { 1 }
        };
        System.out.println("Test 3: " + (ro.orangesRotting(grid3) == -1 ? "PASS" : "FAIL"));

        int[][] grid4 = {
                { 2, 1 }
        };
        System.out.println("Test 4: " + (ro.orangesRotting(grid4) == 1 ? "PASS" : "FAIL"));

        int[][] grid5 = {
                { 0 }
        };
        System.out.println("Test 5: " + (ro.orangesRotting(grid5) == 0 ? "PASS" : "FAIL"));
    }
}