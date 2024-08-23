package Step_if.baekjoon;

import java.util.Scanner;

public class num_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt(); int min = sc.nextInt();
		
		if(min >= 45) {
			System.out.printf("%d %d", hour, min - 45);
		}else {
			if(hour>=1) {
				System.out.printf("%d %d", hour - 1, 60 + (min-45));
			}else
				System.out.printf("%d %d", 23, 60+(min-45));
		}
		
		
	}

}
