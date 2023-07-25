import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1697 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int N = Integer.parseInt(input.split(" ")[0]);
		int K = Integer.parseInt(input.split(" ")[1]);

		int[] check = new int[100001];

		answer = 0;

		Queue queue = new LinkedList<Node>();
		queue.add(new Node(N, 0));
		while (!queue.isEmpty()) {
			Node temp = (Node)queue.poll();

			if(temp.num == K) {
				answer = temp.cnt;
				System.out.println(answer);
				break;
			}

			if(temp.num+1 <= 100000 && check[temp.num+1] == 0) {
				queue.add(new Node(temp.num+1, temp.cnt+1));
				check[temp.num+1] = 1;
			}
			if(temp.num-1 >= 0 && check[temp.num-1] == 0) {
				queue.add(new Node(temp.num-1, temp.cnt+1));
				check[temp.num-1] = 1;
			}
			if(temp.num*2 <= 100000 && check[temp.num*2] == 0) {
				queue.add(new Node(temp.num*2, temp.cnt+1));
				check[temp.num*2] = 1;
			}
		}
	}

	static class Node {
		int num;
		int cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
