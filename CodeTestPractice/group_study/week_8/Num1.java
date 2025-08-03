package group_study.week_8;


public class Num1 {

    static class Solution {
        public int solution(int sticker[]) {

            int stickerLang = sticker.length;


            //배열의 길이가 1인 경우
            if (stickerLang == 1) {
                return sticker[0];
            }
            //배열의 경우가 2인 경우
            if (stickerLang == 2) {
                return Math.max(sticker[0], sticker[1]);
            }

            //첫 번째 원소를 선택한 경우
            int[] dpForStartZero = new int[stickerLang];
            dpForStartZero[0] = sticker[0];
            dpForStartZero[1] = Math.max(dpForStartZero[0], sticker[0]);



            for (int i = 2; i < stickerLang - 1; i++) {

                dpForStartZero[i] = Math.max(dpForStartZero[i - 1],
                    dpForStartZero[i - 2] + sticker[i]);
            }

            //두 번째 원소를 선택한 경우
            int[] dpForStartOne = new int[stickerLang];
            dpForStartOne[0] = 0;
            dpForStartOne[1] = Math.max(dpForStartOne[0], sticker[1]);

            for (int i = 2; i < stickerLang; i++) {
                dpForStartOne[i] = Math.max(dpForStartOne[i - 1],
                    dpForStartOne[i - 2] + sticker[i]);
            }

            System.out.println(dpForStartZero[stickerLang - 2]);
            System.out.println(dpForStartOne[stickerLang - 1]);

            return Math.max(dpForStartZero[stickerLang - 2], dpForStartOne[stickerLang - 1]);
        }
    }


    public static void main(String[] args) {

        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        Solution solution = new Solution();

        int result = solution.solution(sticker);
        System.out.println(result);

    }

}
