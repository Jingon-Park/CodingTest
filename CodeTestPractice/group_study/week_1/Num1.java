package group_study.week_1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스
 * 완전범죄 문제
 * BEST CASE 는 모든 물건을 B가 훔치는 것
 * 모든 물건을 B가 훔치지 못했을 경우 최소한으로 줄여야하는 B의 흔적 갯수를 만들 수 있는지 확인
 *
 */
public class Num1 {
d
    static class Solution {

        public int solution(int[][] info, int n, int m) {
            int answer = 0;

            int sumForB = 0;
            Arrays.sort(info, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int[] data : info) {
                sumForB += data[1];
            }

            if (sumForB < m) {
                return 0;
            }

            int minusB = sumForB - m + 1;

            boolean[] target = new boolean[sumForB + 1];
            int[] priceA = new int[sumForB + 1];
            target[0] = true;

            for (int i = 0; i < info.length; i++) {
                int a = info[i][0];
                int b = info[i][1];

                for (int index = minusB; index >= b; index--){
                    if (target[index - b]){
                        target[index] = true;
                        priceA[index] = priceA[index] == 0 ? priceA[index - b] + a
                            : Math.min(priceA[index], priceA[index - b] + a);
                    }
                }
            }

            for (int i = minusB; i <= target.length; i++) {
                if (target[i]) {
                    answer =  priceA[i];
                    break;
                }
            }
            return answer < n ? answer : -1;
        }
    }
    public static void main(String[] args) {

//        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
//        int n = 4;
//        int m = 4;
        int[][] info = {{3, 3}, {3, 3}};
        int n = 7;
        int m = 1;
        Solution solution = new Solution();

        int result = solution.solution(info, n, m);
        System.out.println(result);
    }

}
