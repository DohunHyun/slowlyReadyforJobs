import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2667 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList result;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0; i<N; i++) {
			String input = br.readLine();
			String[] inputArray = input.split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(inputArray[j]);
			}
		}

		// 결과를 저장할 곳
		result = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		Collections.sort(result);
		System.out.println(result.size());
		for(Object num : result) {
			System.out.println(num);
		}
	}

	private static void bfs(int i, int j) {
		int count = 1;
		Queue queue = new LinkedList();
		queue.add(new Node(i, j));
		visited[i][j] = true;

		while(!queue.isEmpty()) {
			Node temp = (Node)queue.poll();
			int x = temp.x;
			int y = temp.y;

			for (int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx >= 0 && xx < N
					&& yy >= 0 && yy < N
					&& !visited[xx][yy]
					&& map[xx][yy] == 1) {
					queue.add(new Node(xx, yy));
					visited[xx][yy] = true;
					count++;
				}
			}
		}

		result.add(count);
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
