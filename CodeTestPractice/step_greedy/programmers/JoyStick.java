package step_greedy.programmers;

/**
 * 프로그래머스
 * Greedy > 조이스틱 문제 풀이
 * 추가된 테스트 케이스 풀이에 대한 이해가 안됨
 * 풀이 실패
 */
public class JoyStick {
    static class Solution {

        public int solution(String name) {
            // 상하 이동을 위한 최소 이동 횟수 계산
            int totalMove = 0;
            int length = name.length();

            // 각 문자에 대해 상하 이동 최소 횟수를 더함
            for (int i = 0; i < length; i++) {
                char targetChar = name.charAt(i);
                int move = Math.min(targetChar - 'A', 'Z' - targetChar + 1);  // 상하 이동 최소값 계산
                totalMove += move;
            }

            // 좌우 이동을 위한 최소 횟수 계산
            int minLeftRightMove = length - 1;  // 최대 이동 횟수는 문자열 길이 - 1

            for (int i = 0; i < length; i++) {
                int next = i + 1;

                // 'A'가 연속된 부분을 찾아 건너뛰기
                while (next < length && name.charAt(next) == 'A') {
                    next++;
                }

                // 연속된 'A' 구간을 건너뛰는 경우의 최소 좌우 이동 횟수 계산
                minLeftRightMove = Math.min(minLeftRightMove, 2 * i + length - next);
            }

            // 최종 이동 횟수는 상하 이동과 좌우 이동의 합
            totalMove += minLeftRightMove;

            return totalMove;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int solution1 = solution.solution("JAN");
        System.out.println(solution1);

    }

}
