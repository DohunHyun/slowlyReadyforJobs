import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2606 {
	static int count;
	static int comNum, pairNum;
	static int[][] graph;
	static int[] visited;
	static Queue queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		comNum = sc.nextInt();
		pairNum = sc.nextInt();
		graph = new int[comNum+1][comNum+1];
		visited = new int[comNum+1];
		queue = new LinkedList();
		count = 0;

		for(int i=0; i<pairNum; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		search(1);
		System.out.println(count);
	}

	private static void search(int start) {
		visited[start] = 1;
		for(int i=1; i<=comNum; i++) {
			if((graph[start][i] == 1 || graph[i][start] == 1) && visited[i] == 0) {
				visited[i] = 1;
				queue.add(i);
				count++;
			}
		}
		if(!queue.isEmpty()) {
			search((int)queue.poll());
		}

	}
}
