package step_greedy.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class SpeedTrap {

    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < routes.length; i++) {
                int trapPosition = routes[i][1];//현재 차량의 진입점

                //다음 차량들과 겹치는지 확인
                while (i + 1 < routes.length && routes[i + 1][0] <= trapPosition) {//현재 차량의 진출 지점보디 이전에 진입한 차량
                    trapPosition = Math.min(trapPosition, routes[i + 1][1]);//다음 차량의 진출 지점과 현재 차량의 진출지점 중 작은 값으로 설정
                    i++;//다다....음 차량을 확인하기 위해 ++

                }
                answer++;
            }


            return answer;
        }
    }

    public static void main(String[] args) {

        int[][] input = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        Solution solution = new Solution();

        int result = solution.solution(input);

        System.out.println(result);

    }

}
