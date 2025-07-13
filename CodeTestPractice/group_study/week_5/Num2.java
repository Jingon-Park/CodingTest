package group_study.week_5;

import group_study.week_5.Num3.Solution;

public class Num2 {
    static class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for (int i = 0; i < balls.length; i++) {
                answer[i] = calculate(m, n, startX, startY, balls[i][0], balls[i][1]);
            }
            return answer;
        }

        public int getTwoPointLengthPow(int startX, int startY, int ballX, int ballY) {
            int lengthX = Math.abs(ballX - startX);
            int lengthY = Math.abs(ballY - startY);
            return lengthX * lengthX + lengthY * lengthY;
        }

        public int calculate(int m, int n, int startX, int startY, int ballX, int ballY) {

            int result = Integer.MAX_VALUE;
            //좌측 대칭이동
            if (startY == ballY && startX < ballX) {

            }else {
                int leftX = startX * -2;
                int leftY = startY;
                result = Math.min(result, getTwoPointLengthPow(leftX, leftY, ballX, ballY));
            }

            //우측 대칭이동
            if (startY == ballY && ballX > startX) {

            } else {
                int rightX = startX + (Math.abs(m - startX) * 2);
                int rightY = startY;
                result = Math.min(result, getTwoPointLengthPow(rightX, rightY, ballX, ballY));
            }

            //상측 대층이동
            if (startX == ballX && startY < ballY) {

            }else {
                int upX = startX;
                int upY = startY + (Math.abs(n - startY) * 2);
                result = Math.min(result, getTwoPointLengthPow(upX
                    , upY, ballX, ballY));
            }

            //하측 대칭이동
            if (startX == ballX && startX > ballY) {

            }else {
                int downX = startX;
                int downY = startY * -2;
                result = Math.min(result, getTwoPointLengthPow(downX, downY, ballX, ballY));
            }

            return result;
        }

    }
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7, 7,}, {2, 7}, {7, 3}};
        Solution solution = new Solution();

        int[] solution1 = solution.solution(m, n, startX, startY, balls);

        System.out.println(solution1);
    }

}
