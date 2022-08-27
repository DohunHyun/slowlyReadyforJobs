import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_11048 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);

		// 미로 크기 (N, M)
		// N = Integer.parseInt(st.nextToken());
		N = sc.nextInt();
		// M = Integer.parseInt(st.nextToken());
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		// 지도 채우기
		for(int i=0; i<N; i++) {
			// st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				// map[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = sc.nextInt();
			}
		}

		// DFS(0, 0, visited, 0);

		BFS(0, 0);

		System.out.println(answer);
	}

	static void DFS(int x, int y, boolean[][] visited, int sum) {
		// 종료조건
		if(x == N-1 && y == M-1) {
			sum += map[x][y];
			if(sum > answer) {
				answer = sum;
			}
			return;
		}

		// 방문체크, 사탕 더하기
		visited[x][y] = true;
		sum += map[x][y];

		// 세 방향으로 전진
		if(x < N-1) {
			if(!visited[x+1][y]) DFS(x+1, y, visited, sum);
			visited[x+1][y] = false;
		}
		if(y < M-1) {
			if(!visited[x][y+1]) DFS(x, y+1, visited, sum);
			visited[x][y+1] = false;
		}
		if(x < N-1 && y < M-1) {
			if(!visited[x+1][y+1]) DFS(x+1, y+1, visited, sum);
			visited[x+1][y+1] = false;
		}
	}

	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		int[][] max = new int[N][M];
		max[0][0] = map[0][0];

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			for(int i=0; i<3; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];

				if(xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if(visited[xx][yy] == false) {
						queue.add(new Node(xx, yy));
						visited[xx][yy] = true;
						max[xx][yy] = max[node.x][node.y] + map[xx][yy];
					}
					else if(map[xx][yy] + max[node.x][node.y] > max[xx][yy]) {
						max[xx][yy] = map[xx][yy] + max[node.x][node.y];
						queue.add(new Node(xx, yy));
					}
				}
			}
			answer = max[N-1][M-1];
		}
	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
