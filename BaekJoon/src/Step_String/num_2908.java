package Step_String;

import java.util.Scanner;

public class num_2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int left = sc.nextInt();
		int right = sc.nextInt();
		
		left = Integer.parseInt(new StringBuffer().append(left).reverse().toString());
		right = Integer.parseInt(new StringBuffer().append(right).reverse().toString());
		
		if(left > right)
			System.out.println(left);

		else
			System.out.println(right);
		
	}

}
