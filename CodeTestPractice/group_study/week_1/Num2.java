package group_study.week_1;

import java.sql.SQLOutput;

public class Num2 {
    static class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;

            int[] serverInfo = new int[players.length + k];

            for (int i = 0; i < players.length; i++) {
                while ((serverInfo[i] + 1) * m <= players[i]) {
                    answer++;
                    for (int j = 0; j < k; j++) {
                        serverInfo[i + j] += 1;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        Solution solution = new Solution();

        int result = solution.solution(players, m, k);

        System.out.println("result`");
        System.out.println(result);

    }

}
