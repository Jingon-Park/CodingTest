package group_study.week_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num2 {

    static class Solution {
        public int solution(int[][] scores) {

            int[] target = scores[0];//완호 점수


            //완호가 인센 대상자인지 판단
            for(int i = 1; i < scores.length; i++) {
                int left = target[0];
                int right = target[1];

                if (scores[i][0] > left && scores[i][1] > right){
                    return -1;
                }
            }

            //근무 태도를 평가 기준으로 정렬
            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[0] == o1[0]) {
                        return o1[1] - o2[1];//근무 태도가 최고점인 경우 동료평가가 최소점이 앞으로 오도록 정렬
                    }
                    return o2[0] - o1[0];
                }
            });

            int stand = 0;

            List<Integer> rank = new ArrayList<>();
            //근무 태도를 기준으로 정렬 후 동료 평가 최고점을 비교하여 제외
            //배열의 자기 보다 앞자리는 근무 태도가 크거나 같기 때문에 동료 평가가 최고점을 갱신하지 못하면 인센 대상에서 제외
            for (int[] score : scores) {
                if (score[1] >= stand) {
                    stand = score[1];
                    rank.add(score[0] + score[1]);
                }
            }
            rank.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 0; i < rank.size(); i++) {
                if (rank.get(i) == target[0] + target[1]) {
                    return i + 1;
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        Solution solution = new Solution();
        int result = solution.solution(scores);
        System.out.println(result);
    }

}
