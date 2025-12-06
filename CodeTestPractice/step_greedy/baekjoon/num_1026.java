
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class num_1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.nextLine());

        String[] strA = sc.nextLine().split(" ");
        String[] strB = sc.nextLine().split(" ");

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strA[i]);
            B[i] = Integer.parseInt(strB[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[N - i -1];
        }

        System.out.println(result);
    }

}
