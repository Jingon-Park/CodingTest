package group_study.week_1;

import java.util.Arrays;

public class Num3{

    static class Solution {
        public String solution(long n, String[] bans) {
            String answer = "";

            double[] bansOrder = new double[bans.length];


            for (int i = 0; i < bans.length; i++) {
                bansOrder[i] = getOrder(bans[i]);
            }

            Arrays.sort(bansOrder);

            long counter = 0;
            for (int i = 0; i < bans.length; i++) {
                if (bansOrder[i] - i > n){
                    break;
                }
                counter++;
            }
            answer = getStr(n + counter);
            return answer;
        }

        public String getStr(long order) {
            StringBuilder sb = new StringBuilder();
            while (order > 0){
                order--;
                sb.append((char)(97 + order % 26));
                order /= 26;
            }

            return sb.reverse().toString();
        }

        public double getOrder(String str) {

//            double sum = 0;
//            if (str.length() < 2) {
//                return str.charAt(0) - 96;
//            }else {
//                for (int i = 0; i < str.length(); i++) {
//                    sum+= ((str.charAt(i) - 96) * (Math.pow(26, (str.length() - i - 1))));
//                }
//            }

            double sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += (str.charAt(i) - 96) * Math.pow(26, (str.length() - i - 1));
            }

            return sum;
        }
    }

    public static void main(String[] args) {

        int n = 30;
        String[] bans = {"d", "e", "bb", "aa", "ae"};



        Solution solution = new Solution();

        String result = solution.solution(n, bans);

        System.out.println(result);

    }

}
