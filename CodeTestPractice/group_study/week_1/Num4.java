package group_study.week_1;

import java.util.LinkedList;
import java.util.Queue;

public class Num4 {


    static class Solution {


        static boolean[] visited;
        static int answer = -1;
        public int solution(int k, int[][] dungeons) {

            visited = new boolean[dungeons.length];
            dfs(0, k, dungeons);
            return answer;
        }

        public void dfs(int count, int k, int[][] dungeons) {

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true;
                    dfs(count + 1, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
                answer = Math.max(answer, count);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);

    }

}
