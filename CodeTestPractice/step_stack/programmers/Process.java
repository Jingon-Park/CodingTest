package step_stack.programmers;

import java.util.*;

class Process {

	static class Solution {
		public static int solution(int[] priorities, int location) {
			int counter = 0;
			Queue<Integer> queue = new LinkedList<>();
			Queue<Integer> order = new LinkedList<>();

			for (int priority : priorities) {
				queue.add(priority);
			}
			Arrays.sort(priorities);

			for (int i = priorities.length - 1; i >= 0; i--) {
				order.add(priorities[i]);
			}

			System.out.println(queue);
			System.out.println(order);

			while (!queue.isEmpty()) {
				Integer target = queue.poll();
				location--;
				if (target.equals(order.peek())){
					System.out.println("실행 " + target);
					order.poll();
					counter++;
					if (location < 0) {
						break;
					}
				}
				queue.add(target);

				if (location < 0) {
					location = queue.size() - 1;
				}
				System.out.println("location = " + location);
			}
			return counter;
		}
	}

	public static void main(String[] args) {
		Integer count = Solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
		System.out.println(count);
	}
}
