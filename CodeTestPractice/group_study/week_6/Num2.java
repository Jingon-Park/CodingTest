package group_study.week_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Num2 {

    static class Solution {
        public int solution(int[][] scores) {

            int[] target = scores[0];

            for(int i = 1; i < scores.length; i++) {
                int left = target[0];
                int right = target[1];

                if (scores[i][0] > left && scores[i][1] > right){
                    return -1;
                }
            }
            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[0] == o1[0]) {
                        return o2[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });

            int[] stand = scores[0];

            List<Integer> rank = Arrays.stream(scores)
                .filter(ints -> ints[0] >= stand[0] || ints[1] >= stand[1])
                .map(ints -> {
                    return ints[0] + ints[1];
                })
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .collect(Collectors.toCollection(ArrayList::new));

            int targetSum = target[0] + target[1];
            for (int i = 0; i < rank.size(); i++) {
                if (rank.get(i) == targetSum) {
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
