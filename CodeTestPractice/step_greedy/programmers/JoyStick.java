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
            int upDownCounter = 0;//상하 이동 카운터
            int length = name.length();

            int leftRightCounter = length - 1;//좌우 이동 카운터 최대값

            for(int i = 0; i < name.length(); i++) {
                upDownCounter += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
                if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                    int endA = i + 1;
                    while(endA < name.length() && name.charAt(endA) == 'A')
                        endA++;
                    leftRightCounter = Math.min(leftRightCounter, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                    leftRightCounter = Math.min(leftRightCounter, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                }
            }

            return upDownCounter + leftRightCounter;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int solution1 = solution.solution("JAAXNAAAAAN");
        System.out.println(solution1);

    }

}
