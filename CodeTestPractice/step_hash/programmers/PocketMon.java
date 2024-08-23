package step_hash.programmers;

import java.util.HashSet;
import java.util.Set;

public class PocketMon {

    static class Solution{

        public int solution(int[] nums) {

            Set<Integer> monsterSet = new HashSet<>();
            for (int num : nums) {
                monsterSet.add(num);
            }
            return Math.min(nums.length / 2, monsterSet.size());

        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution(new int[]{3, 1, 2, 3});

        System.out.println(result);
    }

}
