package step_greedy;

import java.util.Scanner;

public class num_5585 {
    static final int MONEY = 1000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();

        int change = MONEY - price;

        System.out.println(calculateChangeNum(change));


    }

    static public int calculateChangeNum(int change) {
        final int[] coins = {500, 100, 50, 10, 5, 1};
        int changeNum = 0;

        for (int i = 0; i < coins.length; i++) {

            changeNum += (change / coins[i]);
            change = change % coins[i];
        }
        return changeNum;
    }
}
