import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] array = input.split(" ");

		int F = Integer.parseInt(array[0]); // 총 건물 높이
		int S = Integer.parseInt(array[1]); // 현재 있는 층
		int G = Integer.parseInt(array[2]); // 목적 층
		int U = Integer.parseInt(array[3]); // 위로 이동 횟수
		int D = Integer.parseInt(array[4]); // 아래로 이동 횟수

		Queue queue = new LinkedList<Node>();
		boolean[] visited = new boolean[F+1];

		queue.add(new Node(S, 0));
		visited[S] = true;

		while (!queue.isEmpty()) {
			Node temp = (Node)queue.poll();

			if(temp.floor == G) {
				System.out.println(temp.cnt);
				return;
			}

			if(temp.floor + U <= F && !visited[temp.floor + U]) {
				queue.add(new Node(temp.floor + U, temp.cnt+1));
				visited[temp.floor + U] = true;
			}
			if(temp.floor - D > 0 && !visited[temp.floor - D]) {
				queue.add(new Node(temp.floor - D, temp.cnt+1));
				visited[temp.floor - D] = true;
			}
		}

		System.out.println("use the stairs");
	}

	static class Node {
		int floor;
		int cnt;

		Node(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}
}
