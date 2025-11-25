package workbook_8707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int start = 1;

        int count = 1;

        while (start < input) {
            start = start + (6 * count++);
        }

        System.out.println(count);
    }

}