package group_study.week_7;

import java.util.LinkedList;
import java.util.Queue;

public class Num2 {

    static class Solution {
        static int[] moveN = {1, 0, 0, -1};
        static int[] moveM = {0, -1, 1, 0};
        static char[] appendList = {'d', 'l', 'r', 'u'};
        static StringBuilder sb = new StringBuilder();

        static int nSize;
        static int mSize;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            nSize = n;
            mSize = m;

            int minDist = Math.abs(x - r) + Math.abs(y - c);
            if (minDist > k || (k - minDist) % 2 != 0) return "impossible";

            return dfs(x, y, r,c, k) ? sb.toString() : "impossible";
        }

        public boolean dfs(int x, int y, int r, int c, int k) {

            if (sb.length() == k && x == r && y == c) {
                return true;
            }

            int remainLength = Math.abs(r - x) + Math.abs(c - y);

            if (remainLength > k - sb.length()) {
                return false;
            }


            for (int i = 0; i < 4; i++) {
                int nextX = x + moveN[i];
                int nextY = y + moveM[i];

                if (nextX < 1 || nextX > nSize || nextY < 1 || nextY > mSize) {
                    continue;
                }
                sb.append(appendList[i]);
                boolean result = dfs(nextX, nextY, r, c, k);
                if (result) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String result = solution.solution(3, 4, 2, 3, 3, 1, 5);
        System.out.println(result);
    }

}
