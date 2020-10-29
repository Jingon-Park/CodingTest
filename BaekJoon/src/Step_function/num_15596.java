package Step_function;

public class num_15596 {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(sum(arr));
	}
	static long sum(int[] a) {
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

}
