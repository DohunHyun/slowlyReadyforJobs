import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][M];
		visited = new boolean[N][M];
		answer = Integer.MAX_VALUE;

		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		visited[0][0] = true;
		// calcDistanceDFS(0, 0, 1); // dfs 시간초과 > bfs 이용
		calcDistanceBFS();
		System.out.println(answer);
	}

	static class Node {
		int x;
		int y;
		int count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	private static void calcDistanceBFS() {
		Queue queue = new LinkedList<Node>();
		Node node = new Node(0, 0, 1);

		queue.add(node);
		while(!queue.isEmpty()) {
			Node popNode = (Node)queue.poll();
			if(popNode.x == N-1 && popNode.y == M-1) {
				answer = popNode.count;
				break;
			}
			for(int i=0; i<4; i++) {
				int xx = popNode.x + dx[i];
				int yy = popNode.y + dy[i];

				if(xx >= 0 && xx < N && yy >= 0 && yy < M
					&& map[xx][yy] == 1 && !visited[xx][yy]) {
					queue.add(new Node(xx, yy, popNode.count+1));
					visited[xx][yy] = true;
				}
			}
		}
	}

	// DFS > 시간초과
	private static void calcDistanceDFS(int x, int y, int count) {
		if(x == N-1 && y == M-1) {
			if(count < answer) {
				answer = count;
			}
			return;
		}

		if(answer <= count) return;

		// 밑으로 아니면 오른쪽으로 이동
		if(x+1 < N && map[x+1][y] == 1 && !visited[x+1][y]) {
			visited[x+1][y] = true;
			calcDistanceDFS(x+1, y, count+1);
			visited[x+1][y] = false;
		}
		if(y+1 < M && map[x][y+1] == 1 && !visited[x][y+1]) {
			visited[x][y+1] = true;
			calcDistanceDFS(x, y+1, count+1);
			visited[x][y+1] = false;
		}
		if(x-1 >= 0 && map[x-1][y] == 1 && !visited[x-1][y]) {
			visited[x-1][y] = true;
			calcDistanceDFS(x-1, y, count+1);
			visited[x-1][y] = false;
		}
		if(y-1 >= 0 && map[x][y-1] == 1 && !visited[x][y-1]) {
			visited[x][y-1] = true;
			calcDistanceDFS(x, y-1, count+1);
			visited[x][y-1] = false;
		}
		return;
	}
}
