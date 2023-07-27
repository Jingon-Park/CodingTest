package step_greedy;

import java.util.Scanner;

public class num_14916 {

    static int COIN_5 = 5;
    static int COIN_2 = 2;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int changeAmount = sc.nextInt();
        int minChangeCoinNumber = getMinChangeCoinNumber(changeAmount);

        System.out.println(minChangeCoinNumber);

    }

    public static int getMinChangeCoinNumber(int changeAmount) {

        int coin5_num = changeAmount / COIN_5;
        int coin2_num = 0;

        if (changeAmount < 5) {
            if (changeAmount % 2 != 0) {
                return -1;
            } else {
                return changeAmount / COIN_2;
            }
        }

        while (true) {
            if ((changeAmount - (COIN_5 * coin5_num)) % COIN_2 == 0){
                return coin5_num + ((changeAmount - (COIN_5 * coin5_num)) / COIN_2);
            }

            coin5_num--;
        }

    }
}
