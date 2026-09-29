package Leetcode.CourseSchedule;


import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); // courses , List of pre-req
        // boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            // visited[i] = false;
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) { // 0,1,2 .. n -> check cycle for all of these\
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[numCourses];
            for (int pre : graph.get(i)) {
                queue.offer(pre);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int z = 0; z < size; z++) {
                    int course = queue.poll(); // 1 , 2
                    if (course == i) {
                        return false; //circle detected 
                    }
                    if (visited[course]) {
                        continue;
                    }
                    visited[course] = true;
                    for (int k : graph.get(course)) {// enter all preq for that course now
                        queue.offer(k);
                    }
                }
            }
        }
        return true;
    }
}

// bad approach 
// Time = O(V * (V+E)).  , should be O(V+E)


// map(int, List<int>)
//.    ( course, [course depending on] )
//          0, [1, 2]
//          1, [2, 4]
//          2, [3]
//          3, []
//          4, [5]
//          5, [1]

//          Queue() <- 4
//          2 -> pushed into queue


// [0,1] [0,2] [1, 2] [ 2, 3] [ 1 , 4] [ 4 , 5] [ 5,  1]