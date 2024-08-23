package step_string.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		String temp = input;
		
		
		String[] arr = {"c=", "c-", "dz=", "d-","lj", "nj", "s=", "z="};
		
		for(int i = 0; i < arr.length; i++) {
			if(input.contains(arr[i])) {
				input = input.replaceAll(arr[i], "+");
			}
		}
		int counter = input.length();
		System.out.println(counter);
			
		
	}

}
