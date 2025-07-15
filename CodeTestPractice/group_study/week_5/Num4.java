package group_study.week_5;

public class Num4 {

    static class Solution {
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;
            int startSec = h1 * 60 * 60 + m1 * 60 + s1;
            int endSec = h2 * 60 * 60 + m2 * 60 + s2;

            double currentH = (startSec / 120d) % 360;
            double currentM = (startSec / 10d ) % 360;
            double currentS = (startSec * 6) % 360;

            if (currentS == currentH || currentS == currentM) {
                answer++;
            }

            while (endSec > startSec) {
                double hPosition = (startSec / 120d) % 360;
                double mPosition = (startSec / 10d ) % 360;
                double sPosition = (startSec * 6) % 360;



                double nHPosition = ((startSec + 1d) / 120d) % 360;
                double nMPosition = ((startSec + 1d) / 10d ) % 360;
                double nSPosition = ((startSec + 1d) * 6d) % 360;

                nHPosition = nHPosition == 0 ? 360 : nHPosition;
                nMPosition = nMPosition == 0 ? 360 : nMPosition;
                nSPosition = nSPosition == 0 ? 360 : nSPosition;


                if (sPosition < hPosition && nSPosition >= nHPosition) {
                    answer++;
                }

                if (sPosition < mPosition && nSPosition >= nMPosition) {
                    answer++;
                }
                if (nSPosition == nHPosition && nSPosition == nMPosition) {
                    answer--;
                }
                startSec++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        int h1 = 0;
        int m1 = 5;
        int s1 = 30;
        int h2 = 0;
        int m2 = 7;
        int s2 = 0;
        Solution solution = new Solution();

        int result = solution.solution(h1, m1, s1, h2, m2, s2);
        System.out.println(result);

    }

}
