package group_study.week_2;

public class Num3 {

    static class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int answer = 1;
            long remainLimit = limit - times[0];


            while (true) {
                long price = 0L;
                for (int i = 1; i < diffs.length; i++) {
                    price += getPrice(i, diffs, times, answer);
//                    System.out.println(i + " 번째 : " + price + " remain = " + (remainLimit - price));
                    if (price > remainLimit) {
//                        System.out.println("Fail");
                        while (!(price < remainLimit)) {
                            long tempPrice = 0L;
                            answer++;
                            for (int j = 1; j <= i; j++) {
                                tempPrice += getPrice(j, diffs, times, answer);
                            }
//                            System.out.println("Lv = " + answer);
                            price = tempPrice;
                        }
                    }
                }
                break;
            }

            return answer;
        }

        public int getPrice(int index, int[] diffs, int[] times, int lv) {
            if (index < 1) {
                return -1;
            }
            if (diffs[index] <= lv) {
                return diffs[index];
            }
            return (times[index - 1] + times[index]) * (diffs[index] - lv) + times[index];
        }
    }
    public static void main(String[] args) {

        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        int limit = 30;


//        int[] diffs = {1,4,4,2};
//        int[] times = {6,3,8,2};
//        int limit = 59;

        Solution solution = new Solution();

        int result = solution.solution(diffs, times, limit);

        System.out.println(result);

    }

}
