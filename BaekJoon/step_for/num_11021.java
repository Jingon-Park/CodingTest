package step_for;

import java.util.Scanner;

public class num_11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		
		for(int i = 1; i <= time; i++) {
			System.out.println("Case #" + i +": " + (sc.nextInt() + sc.nextInt()));
		}
	}

}
