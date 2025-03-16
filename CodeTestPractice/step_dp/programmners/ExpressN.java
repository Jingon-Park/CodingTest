package step_dp.programmners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressN {
    static class Solution {
        public int solution(int N, int number) {
            List<Set<Integer>> dp = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                dp.add(new HashSet<>());
                int num = 0;
                for (int j = 0; j <= i; j++) {
                    num = num * 10 + N;
                }
                dp.get(i).add(num);
                if (i > 0){
                    for (int j = 0; j < i; j++) {
                        for (int num1 : dp.get(j)) {
                            for (int num2 : dp.get(i - j - 1)) {
                                dp.get(i).add(num1 + num2);
                                dp.get(i).add(num1 - num2);
                                dp.get(i).add(num1 * num2);
                                if (num2 != 0) {
                                    dp.get(i).add(num1 / num2);
                                }
                            }
                        }
                    }
                }

                if (dp.get(i).contains(number)) {
                    return i + 1;
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {

        int N = 5;
        int number = 12;
        Solution solution = new Solution();
        int result = solution.solution(N, number);

        System.out.println(result);

    }

}
