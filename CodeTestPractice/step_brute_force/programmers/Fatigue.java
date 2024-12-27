package programmers;

/**
 * 완전탐색 / 피로도
 */
public class Fatigue {

    static boolean[] visited;
    static int counter = 0;
    static class Solution {
        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];

            dfs(0, k, dungeons);

            return counter;
        }

        public void dfs(int depth, int k, int[][] dungeons) {

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true;
                    dfs(depth+ 1, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }
            counter = Math.max(counter, depth);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        int solution1 = solution.solution(80, dungeons);

        System.out.println(solution1);
    }

}
