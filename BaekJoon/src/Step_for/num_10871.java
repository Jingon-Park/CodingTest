package Step_for;

import java.util.Scanner;

public class num_10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int max = sc.nextInt();
		int[] arr = new int[count];
		
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < max)
				System.out.print(arr[i] + " ");
		}
	}

}
