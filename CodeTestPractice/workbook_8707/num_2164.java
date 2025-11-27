package workbook_8707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= input; i++) {
            queue.add(i);
        }

        int i = 0;
        while (queue.size() > 1) {
            if (i % 2 == 0) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            i++;
        }
        System.out.println(queue.peek());
    }
}
