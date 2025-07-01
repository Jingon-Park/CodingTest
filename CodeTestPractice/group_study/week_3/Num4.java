package group_study.week_3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 귤 고르기
 */
public class Num4 {

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i : tangerine) {
                Integer counter = map.getOrDefault(i, 0);
                map.put(i, counter + 1);

            }
            List<Integer> collect = map.keySet().stream().collect(Collectors.toList());

            Collections.sort(collect, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    Integer o1Value = map.get(o1);
                    Integer o2Value = map.get(o2);
                    return o2Value - o1Value;
                }
            });

            int index = 0;
            while (k > 0) {
                Integer key = collect.get(index);
                Integer count = map.get(key);
                index++;
                k -= count;
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int k = 6;
        int[] trangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        Solution solution = new Solution();
        int result = solution.solution(k, trangerine);
        System.out.println(result);

    }

}
