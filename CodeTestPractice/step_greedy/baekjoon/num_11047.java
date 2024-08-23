package step_greedy.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class num_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int coinTypeNum = sc.nextInt();
        int targetWon = sc.nextInt();
        int needCoinNum = 0;

        int[] coinType = new int[coinTypeNum];

        for (int i = 0; i < coinTypeNum; i++) {
            coinType[i] = sc.nextInt();
        }

        for (int i = coinTypeNum - 1; i >= 0; i--) {
            needCoinNum += (targetWon / coinType[i]);
            targetWon = (targetWon % coinType[i]);
        }

        System.out.println(needCoinNum);






    }
}
