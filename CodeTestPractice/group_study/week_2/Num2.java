package group_study.week_2;

import java.util.HashSet;
import java.util.Set;

public class Num2 {
    static class Solution {

        static boolean[] visitied;
        static int counter = 0;
        public int solution(int n, int[][] q, int[] ans) {

            visitied = new boolean[n + 1];
            Set<Integer> current = new HashSet<>();

            dfs(n, 1, q, ans, current);
            return counter;
        }

        public void dfs(int n, int startIndex, int[][] q, int[] ans, Set<Integer> current) {
            if (n - startIndex + 1 + current.size() < 5) {
                return;
            }


            for (int i = startIndex; i <= n; i++) {
                if (!visitied[i]) {
                    current.add(i);
                    visitied[i] = true;
                }
                if (current.size() == 5) {
                    boolean allMatch = true;
                    for (int j = 0; j < ans.length; j++) {
                        int matchCounter = 0;
                        int[] matchTarget = q[j];
                        for (int num : matchTarget) {
                            if (current.contains(num)) {
                                matchCounter++;
                                if (matchCounter > ans[j]) {
                                    allMatch = false;
                                    break;
                                }
                            }
                        }
                        if (matchCounter != ans[j]) {
                            allMatch = false;
                            break;
                        }
                    }
                    if (allMatch) {
                        counter++;
                    }
                }
                if (current.size() < 5) {
                    dfs(n, i + 1, q, ans, current);
                }
                visitied[i] = false;
                current.remove(i);
            }
        }
    }
    public static void main(String[] args) {

        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3,};

        Solution solution = new Solution();

        int result = solution.solution(n, q, ans);

        System.out.println(result);


    }

}
