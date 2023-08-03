import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int maxAmount = 0;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};

		for(int i=0; i<N; i++) {
			String input = br.readLine();
			String[] array = input.split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(array[j]);
				maxAmount = maxAmount < map[i][j] ? map[i][j] : maxAmount;
			}
		}

		int answer = 0;

		for(int r=0; r<=maxAmount; r++) {
			// bfs 돌리고, 구역 개수 저장하고.
			Queue queue = new LinkedList();
			boolean[][] visited = new boolean[N][N];
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > r && !visited[i][j]) {
						// 첫 시작
						queue.add(new Node(i, j));
						visited[i][j] = true;
						count++;
						while(!queue.isEmpty()) {
							Node temp = (Node)queue.poll();

							for(int k=0; k<4; k++) {
								int xx = temp.i + dx[k];
								int yy = temp.j + dy[k];

								if(xx >= 0 && xx < N && yy >=0 && yy < N
										&& map[xx][yy] > r && !visited[xx][yy]){
									queue.add(new Node(xx, yy));
									visited[xx][yy] = true;
								}
							}

						}

					}
				}
			}
			answer = answer > count ? answer : count;
		}
		System.out.println(answer);
	}

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
