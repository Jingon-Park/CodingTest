package group_study.week_4;

/**
 * 두 원 사이의 정수 쌍
 */
public class Num3 {

    static class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            long r1Value = (long) r1 * r1; //작은 원의 반지름 제곱
            long r2Value = (long) r2 * r2; //큰원의 반지름 제곱

            long cnt = 0; // 1사분면의 점 개수
            long duplicateCnt = 0; //1 ~ 4 사분면의 점 개수에서 중복 카운트 수

            for (int x = 0; x <= r2; x++) {
                long xValue = (long) x * x; // r1^2 <= a^2 + b^2 <= r2^2 에서 a를 알고있을 때 b의 최소값 최대값을 구하기 위함
                int yMin = (int) Math.ceil(Math.sqrt(r1Value - xValue)); // r1^2 <= a^2 + b^2 --> r1^2 - a^2 <= b^2을 만족하는 최소 정수
                int yMax = (int) Math.sqrt(r2Value - xValue); // r2^2 - a^2 >= b^2을 만족하는 정수

                int minus = yMax - yMin + 1; //최소값과 최대값 사이의 정수 갯수
                cnt += minus;
                if (x == 0) {
                    duplicateCnt += minus;
                }
            }
            answer = (cnt * 4) - (duplicateCnt * 4);

            return answer;
        }
    }
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        Solution solution = new Solution();
        long result = solution.solution(r1, r2);
        System.out.println(result);

    }

}
