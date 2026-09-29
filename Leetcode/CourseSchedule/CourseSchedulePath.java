package Leetcode.CourseSchedule;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedulePath {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){ // 0,1,2,3.    ; 0 -> 1 -> 2
            if(!visited[i] && hasCycle(i, graph, visited, path)){
                return false;
            }
        }

        return true;
    }
    public boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visited, boolean[] path){
        if(visited[course])
            return false;
        if(path[course]){ // means course is in th epath like 1->2->3->1 (path[1] = true)
            return true;
        }
        visited[course] = true;
        path[course] = true;
        // otherwise check prereq of prereqs
        for(int prereq : graph.get(course)){
            if(hasCycle(prereq, graph, visited, path)){
                return true;
            }
        }
        path[course] = false;
        return false;
    }
}
