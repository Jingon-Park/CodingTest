package step_function.baekjoon;

public class num_1065 {

	public static void main(String[] args) {
		int input = 210;
		int counter = 0;
		
		for(int i = 1; i <= input; i++) {
			int num = i;
			if(num < 100) {
				counter++;
				continue;
			}
			int num1 = num % 10;
			int num2 = (num / 10) % 10;
			int num3 = (num / 100);
			if(num1 - num2 == num2 - num3){
				counter++;
			}
		}
		System.out.println(counter);
	}

}
