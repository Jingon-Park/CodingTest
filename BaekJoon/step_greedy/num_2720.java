package step_greedy;

import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.stream.Stream;

public class num_2720 {

    final static int QUARTER = 25;
    final static int DIME = 10;
    final static int NICKEL = 5;
    final static int PENNY = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] result = new int[num][4];

        for (int i = 0; i < num; i++) {

            result[i] = calculateChangeNum(sc.nextInt());
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static int[] calculateChangeNum(int amount) {

        int change = amount;
        int[] result = new int[4];

        if (change / QUARTER > 0) {
            result[0] = change / QUARTER;
            change = change % QUARTER;
        }

        if (change / DIME > 0) {
            result[1] = change / DIME;
            change = change % DIME;
        }

        if (change / NICKEL > 0) {
            result[2] = change / NICKEL;
            change = change % NICKEL;
        }

        result[3] = change / PENNY;
        return result;
    }


}
