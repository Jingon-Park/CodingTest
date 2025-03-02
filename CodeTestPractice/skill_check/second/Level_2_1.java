package skill_check.second;

import java.util.HashSet;
import java.util.Set;

public class Level_2_1 {
    static class Solution {
        public int[] solution(int n, String[] words) {
            int count = 0;
            String last = "";

            Set<String> history = new HashSet<>();


            for (int i = 0; i < words.length; i++) {

                String current = words[i];
                if (history.contains(current)) {
                    count = i;
                    break;
                }else {
                    history.add(current);
                    if (last.length() > 0 && last.charAt(last.length() - 1) != current.charAt(0)) {
                        count = i;
                        break;
                    }
                    last = current;
                }
            }
            System.out.println(count);


            if (count > 0) {
                count++;
                int num = count % n;
                if (num == 0) {
                    num = n;
                }
                int counter = count / n;
                if (count % n > 0) {
                    counter++;
                }
                return new int[] {num, counter};
            }
            return new int[] {0, 0};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int n = 5;
//        String[] input = {"hello", "observe", "effect", "take", "either", "recognize", "encourage",
//            "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        int n = 2;
        String[] input = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution.solution(n, input);
        System.out.println(result[0] + ", " + result[1]);
    }
}
