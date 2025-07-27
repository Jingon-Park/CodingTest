package group_study.week_7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Num1 {


    static class Solution {



        public int[] solution(int n, int[][] roads, int[] sources, int destination) {

            Map<Integer, Set<Integer>> roadMap = initRoadMap(roads);

            int[] minLengths = getMinLengthsFrom(destination, roadMap, n);

            int[] answer = new int[sources.length];

            for (int i = 0; i < sources.length; i++) {
                answer[i] = minLengths[sources[i]] == Integer.MAX_VALUE ? -1 : minLengths[sources[i]];
            }

            return answer;
        }

        private Map<Integer, Set<Integer>> initRoadMap(int[][] roads) {
            Map<Integer, Set<Integer>> roadMap = new HashMap<>();

            for (int[] road : roads) {
                int leftSite = road[0];
                int rightSite = road[1];

                Set<Integer> leftLinkedSite = roadMap.getOrDefault(leftSite, new HashSet<>());
                leftLinkedSite.add(rightSite);
                roadMap.put(leftSite, leftLinkedSite);

                Set<Integer> rightLinkedSite = roadMap.getOrDefault(rightSite, new HashSet<>());
                rightLinkedSite.add(leftSite);
                roadMap.put(rightSite, rightLinkedSite);
            }

            return roadMap;
        }

        private int[] getMinLengthsFrom(int start, Map<Integer, Set<Integer>> roadMap, int nodeSize) {

            boolean[] visited = new boolean[nodeSize + 1];
            int[] minLengths = new int[nodeSize + 1];

            for (int i = 0; i < minLengths.length; i++) {
                minLengths[i] = Integer.MAX_VALUE;
            }

            Queue<int[]> queue = new LinkedList<>();
            Set<Integer> linkedFromDestination = roadMap.get(start);

            minLengths[start] = 0;

            linkedFromDestination.iterator().forEachRemaining(site -> {
                if (!visited[site]) {
                    queue.add(new int[]{site, 1});
                    visited[site] = true;
                }
            });

            while (!queue.isEmpty()) {
                int[] site = queue.poll();
                minLengths[site[0]] = Math.min(minLengths[site[0]], site[1]);
                Set<Integer> linkedSite = roadMap.get(site[0]);

                linkedSite.iterator().forEachRemaining(nextSite -> {
                    if (!visited[nextSite]) {
                        queue.add(new int[]{nextSite, site[1] + 1});
                        visited[nextSite] = true;
                    }
                });
            }

            return minLengths;
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
