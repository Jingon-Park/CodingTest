package group_study.week_9;

import java.util.HashSet;
import java.util.Set;

public class Num2 {
    static class Solution {

        boolean[][] tree;
        int maxSheep = 0;
        int[] info;
        public int solution(int[] info, int[][] edges) {
            int nodeSize = info.length;
            this.info = info;
            tree = new boolean[nodeSize][nodeSize];

            for (int[] node : edges) {
                tree[node[0]][node[1]] = true;
            }

            boolean[] rootChild = tree[0];
            Set<Integer> child = new HashSet<>();
            for (int i = 1; i < rootChild.length; i++) {
                if (rootChild[i]) {
                    child.add(i);
                }
            }

            dfs(1, 0, child);
            return maxSheep;
        }

        void dfs(int sheep, int wolf, Set<Integer> child) {
            maxSheep = Math.max(sheep, maxSheep);

            for (Integer nextNode : child) {
                int nextSheep = sheep + (info[nextNode]== 0 ? 1 : 0);
                int nextWolf = wolf + (info[nextNode] == 1 ? 1 : 0);


                if (nextSheep <= nextWolf) {
                    continue;
                }
                Set<Integer> copyChild = new HashSet<>(child);
                copyChild.remove(nextNode);
                boolean[] nextNodeChild = tree[nextNode];

                for (int i = 1; i < nextNodeChild.length; i++) {
                    if (nextNodeChild[i]) {
                        copyChild.add(i);
                    }
                }
                dfs(nextSheep, nextWolf, copyChild);
            }

        }
    }
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5},
            {4, 6}, {8, 9}};
        Solution solution = new Solution();

        int result = solution.solution(info, edges);
        System.out.println(result);


    }

}
