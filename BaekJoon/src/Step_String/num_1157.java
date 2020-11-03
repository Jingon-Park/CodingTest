package Step_String;

import java.util.Scanner;

public class num_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] counter = new int[input.length()];
		
		for(int i = 0; i <  input.length(); i++) {
			int maxCompare = 0;
			String compare = Character.toString(input.charAt(i));
			for(int j = i + 1; j < input.length(); j++) {
				if(compare.equalsIgnoreCase(Character.toString(input.charAt(j)))){
					maxCompare++;
				}
				counter[i] = maxCompare + 1;
			}
			
		}
		for(int i : counter) {
			System.out.println(i);
		}
	}

}
