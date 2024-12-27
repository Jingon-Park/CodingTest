package programmers;

/**
 * 완전탐색 / 최소 사각형
 */
public class MinSquare {

    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int maxX = 0;
            int maxY = 0;

            for (int[] size : sizes) {
                int x = size[0];
                int y = size[1];

                if (x > y) {
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }else {
                    maxX = Math.max(maxX, y);
                    maxY = Math.max(maxY, x);
                }
            }

            return maxX * maxY;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        int solution1 = solution.solution(input);
        System.out.println(solution1);
    }

}
