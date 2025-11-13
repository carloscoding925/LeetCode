package Java.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_CourseSchedule {
    public static void main(String[] args) {
        System.out.println("#207 - Course Schedule - Medium");

        int numCourses = 2;
        int[][] prereqs = {{1, 0}, {0, 1}};

        boolean isPossible = canFinish(numCourses, prereqs);
        System.out.println("Can Finish: " + isPossible);

        return;
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesCompleted = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesCompleted++;

            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return coursesCompleted == numCourses;
    }
}
