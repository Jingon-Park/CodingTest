package programmers;

import java.util.Stack;

/**
 * 완전탐색 / 전력망 나누기
 */
public class ElectricalGrid {


    static class Solution {
        static boolean[][] grid;
        static boolean[] visited;
        static int result = Integer.MAX_VALUE;
        public int solution(int n, int[][] wires) {

            grid = new boolean[n + 1][n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < wires.length; i++) {
                int x = wires[i][0];
                int y = wires[i][1];
                grid[x][y]= true;
                grid[y][x] = true;
            }

            for (int x = 1; x < grid.length; x++) {
                for (int y = 1; y < grid.length; y++) {
                    if (grid[x][y] && grid[y][x]) {
                        grid[x][y] = false;
                        grid[y][x] = false;
                        explore();
                        visited = new boolean[n + 1];
                        grid[x][y] = true;
                        grid[y][x] = true;
                    }
                }
            }
            return result;
        }

        public void explore() {
            for (int node = 1; node < visited.length; node++) {
                if (!visited[node]) {
                    int groups = counter(node);
                    result = Math.min(result, Math.abs(visited.length - groups - 1 - groups));
                    break;
                }
            }
        }

        public int counter(int startNode) {
            int counter = 0;

            Stack<Integer> stack = new Stack<>();
            stack.add(startNode);
            while (!stack.isEmpty()) {
                Integer currentNode = stack.pop();
                if (!visited[currentNode]) {
                    visited[currentNode] = true;
                    counter++;
                    for (int i = 1; i < grid[currentNode].length; i++) {
                        if (grid[currentNode][i]) {
                            stack.add(i);
                        }
                    }
                }
            }
            return counter;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int n = 4;

        int result = solution.solution(n, wires);

        System.out.println(result);
    }

}
