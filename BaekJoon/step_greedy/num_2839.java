package step_greedy;

import java.util.Scanner;

public class num_2839 {

    final static int BAG_5 = 5;
    final static int BAG_3 = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kiloGram = scanner.nextInt();
        System.out.println(minBagNum(kiloGram));




    }

    public static int minBagNum(int kiloGram) {
        int bagNum = 0;

        while (true) {
            if (kiloGram % BAG_5 == 0) {
                bagNum += kiloGram / BAG_5;
                break;
            }

            kiloGram -= BAG_3;
            bagNum++;

            if (kiloGram < 0) {
                bagNum = -1;
                break;
            }


        }
        return bagNum;
    }

}
