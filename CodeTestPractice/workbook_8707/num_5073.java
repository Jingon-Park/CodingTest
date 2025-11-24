package workbook_8707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class num_5073 {

    public static void main(String[] args) throws IOException {

        final String END_LINE = "0 0 0";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (END_LINE.equals(input)) {
                break;
            }

            String[] splitInput = input.split(" ");

            List<Integer> collect = Arrays.stream(splitInput).map(Integer::parseInt)
                .collect(Collectors.toList());

            collect.sort((a, b) -> b - a);

            if (collect.get(0) >= collect.get(1) + collect.get(2)) {
                System.out.println("Invalid");
                continue;
            }

            Set<Integer> lineLengths = new HashSet<>(collect);

            if (lineLengths.size() == 1) {
                System.out.println("Equilateral");
                continue;
            }

            if (lineLengths.size() == 2) {
                System.out.println("Isosceles");
                continue;
            }

            if (lineLengths.size() == 3) {
                System.out.println("Scalene");
                continue;
            }

            System.out.println("Invalid");
        }

    }

}
