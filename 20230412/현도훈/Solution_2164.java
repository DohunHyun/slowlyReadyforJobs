import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2164 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			queue.add(i+1);
		}

		while(queue.size() > 1) {
			queue.poll();
			int temp = queue.poll();
			queue.add(temp);
		}

		System.out.println(queue.peek());

	}
}
