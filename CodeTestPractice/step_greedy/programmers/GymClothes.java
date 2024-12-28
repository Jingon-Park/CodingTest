package step_greedy.programmers;

/**
 그리디 / 체육복
 */
public class GymClothes {

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] clothes = new int[n + 1];

            for (int i = 0; i < lost.length; i++) {
                int lostNum = lost[i];
                clothes[lostNum] -= 1;
            }

            for (int i = 0; i < reserve.length; i++) {
                int reserveNum = reserve[i];
                clothes[reserveNum] += 1;
            }

            for (int i = n; i > 0; i--) {
                if (clothes[i] < 0) {
                    if (i + 1 <= n && clothes[i + 1] > 0) {
                        clothes[i] +=1;
                        clothes[i + 1] -= 1;
                    } else if (i - 1 > 0 && clothes[i - 1] > 0) {
                        clothes[i] += 1;
                        clothes[i - 1] -= 1;
                    }
                }
            }

            int lostNum = 0;
            for (int i = 1; i <= n; i++) {
                if (clothes[i] < 0) {
                    lostNum++;
                }
            }
            return n - lostNum;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};
        Solution solution = new Solution();
        int solution1 = solution.solution(n, lost, reserve);
        System.out.println(solution1);
    }

}
