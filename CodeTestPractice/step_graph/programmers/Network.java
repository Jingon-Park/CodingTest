package step_graph.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    static class Solution {

        static boolean[] visited;
        static int counter;
        public int solution(int n, int[][] computers) {

            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                bfs(i, computers);
            }


            return counter;
        }

        public void bfs(int start, int[][] computers) {

            if (visited[start]) {
                return;
            }

            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;

            for (int i = 0; i < computers[start].length; i++) {
                int connected = computers[start][i];
                if (connected == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

            while (!queue.isEmpty()) {
                Integer computer = queue.poll();
                for (int i = 0; i < computers[computer].length; i++) {
                    int childConnected = computers[computer][i];
                    System.out.println(computer + " " + i  + " 확인  : " +  childConnected);
                    if (childConnected == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            counter++;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Solution solution = new Solution();
        int result = solution.solution(n, computers);
        System.out.println(result);
    }
}
