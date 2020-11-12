package Step_function;

public class num_15596 {

	public static void main(String[] args) {
		test Test = new test();
		int[] arr = {1,2,3,4,5};
		
		System.out.println(Test.sum(arr));
		
		
	}

}
class test{
	long sum(int[] a) {
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}