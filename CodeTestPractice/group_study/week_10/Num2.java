package group_study.week_10;

import java.util.*;
import java.util.stream.Collectors;

public class Num2 {
    static class Solution {
        public int solution(int n, int[][] lighthouse) {
            int answer = 0;
            Map<Integer, Set<Integer>> treeMap = new HashMap<>();
            Set<Integer> lights = new HashSet<>();

            for (int[] ints : lighthouse) {
                int x = ints[0];
                int y = ints[1];
                Set<Integer> xLink = treeMap.getOrDefault(x, new HashSet<>());
                Set<Integer> yLink = treeMap.getOrDefault(y, new HashSet<>());
                xLink.add(y);
                yLink.add(x);

                treeMap.put(x, xLink);
                treeMap.put(y, yLink);
            }

            List<Integer> nodeList = treeMap.keySet().stream().collect(Collectors.toList());

            nodeList.sort((node1, node2) -> {
                int node1Size = treeMap.get(node1).size();
                int node2Size = treeMap.get(node2).size();
                return node2Size - node1Size;
            });

            int index = 0;
            while (lights.size() < n) {
                Integer node = nodeList.get(index);
                index++;

                System.out.println("node = " + node);

                Set<Integer> child = treeMap.get(node);
                long count = child.stream().filter(integer -> {
                    boolean result = !lights.contains(integer);
                    if (result) {
                        System.out.println("X " + integer);
                    }
                    return result;
                }).count();

                if (count > 0) {
                    System.out.println("add " + node);
                    lights.add(node);
                    answer++;

                    for (Integer integer : child) {
                        lights.add(integer);
                    }
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {

        int n = 10;
        int[][] lighthouse = 	{{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};

        Solution solution = new Solution();

        int result = solution.solution(n, lighthouse);
        System.out.println(result);


    }

}
