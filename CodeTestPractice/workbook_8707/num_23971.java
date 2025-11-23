package workbook_8707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/23971
 * ZOAC 4
 */
public class num_23971 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int N = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);

        int wCount = (int) Math.ceil((double) H /(double) (N + 1));
        int hCount = (int) Math.ceil((double) W / (double) (M + 1));

        System.out.println(wCount * hCount);

    }

}
