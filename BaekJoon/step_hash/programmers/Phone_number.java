package step_hash.programmers;

import java.util.*;

class Phone_number {


	static class Solution {
		public static boolean solution(String[] phone_book) {

			HashMap<String, Integer> map = new HashMap<>();

			for(String num : phone_book){
				map.put(num, 1);
			}

			for(String num : phone_book){
				for(int i = 0; i < num.length(); i++){
					String substr = num.substring(0, i);
					if(map.containsKey(substr)) return false;
				}
			}

			return true;
		}
	}

	public static void main(String[] args) {
		Boolean result = Solution.solution(new String[]{"119", "97674223", "1195524421" });

		System.out.println(result);
	}
}