package group_study.week_7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Num1 {
    static class Solution {

        static Map<Integer, Set<Integer>> map = new HashMap<>();
        static boolean[] visited;
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            visited = new boolean[n + 1];

            for (int[] road : roads) {
                int start = road[0];
                int end = road[1];
                Set<Integer> linkedRoad = map.getOrDefault(start, new HashSet<>());
                linkedRoad.add(end);
                map.put(start, linkedRoad);

                Set<Integer> endLinkedRoad = map.getOrDefault(end, new HashSet<>());
                endLinkedRoad.add(start);
                map.put(end, endLinkedRoad);
            }

            for (int i = 0; i < sources.length; i++) {
                int source = sources[i];
                int result = bfs(source, destination);
                visited = new boolean[n + 1];
                answer[i] = result;
            }

            return answer;
        }

        public int bfs(int current, int destination) {

            visited[current] = true;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{current, 0});

            while (!queue.isEmpty()) {
                int[] currentPosition = queue.poll();

                if (currentPosition[0] == destination) {
                    return currentPosition[1];
                }

                Set<Integer> linkedRoads = map.getOrDefault(currentPosition[0], new HashSet<>());
                linkedRoads.iterator().forEachRemaining(site -> {
                    if (!visited[site]) {
                        queue.add(new int[]{site, currentPosition[1] + 1});
                        visited[site] = true;
                    }
                });
            }
            return -1;
        }
    }
    public static void main(String[] args) {
//        int n = 3;
//        int[][] roads = {{1, 2}, {2, 3}};
//        int[] sources = {2, 3};
//        int destination = 1;


        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};

        int[] sources = {1,3,5};
        int destination = 5;
        Solution solution = new Solution();

        int[] result = solution.solution(n, roads, sources, destination);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

}
