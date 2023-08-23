import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] array = input.split(" ");
		int M = Integer.parseInt(array[0]); // 박스 가로
		int N = Integer.parseInt(array[1]); // 박스 세로
		int H = Integer.parseInt(array[2]); // 박스 높이

		int[][][] box = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];

		// 위 아래 좌 우 앞 뒤
		int[] dx = {0, 0, -1, 1, 0, 0};
		int[] dy = {0, 0, 0, 0, -1, 1};
		int[] dz = {-1, 1, 0, 0, 0, 0};

		boolean alreadyDone = true;
		Queue queue = new LinkedList();
		Queue nextQueue = new LinkedList();
		int day = 0;
		int total = 0;
		int num = 0;

		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				input = br.readLine();
				array = input.split(" ");
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(array[k]);
					if(alreadyDone) {
						if(box[i][j][k] == 0) {
							alreadyDone = false;
						}
					}

					if(box[i][j][k] == 1) {
						// 익은 토마토면 큐에 넣기
						nextQueue.add(new Node(k, j, i));
						visited[i][j][k] = true;
						num++;
					}
					if(box[i][j][k] >= 0) total++;
				}
			}
		}

		if(alreadyDone) {
			System.out.println("0");
			return;
		}

		// 익은 애들을 큐에 넣고 걔네 주변애들중 안익은 애들이 익게 해야하지
		// 그리고 방금 익은 애들을 큐에 넣고 주변 안익은 애들 익게하고,

		while (!nextQueue.isEmpty()) {
			queue = nextQueue;
			nextQueue = new LinkedList();

			while(!queue.isEmpty()) {
				// 익은 토마토들 주변 토마토 있으면 익게 만들기
				Node temp = (Node)queue.poll();

				for(int i=0; i<dx.length; i++) {
					int xx = temp.x + dx[i];
					int yy = temp.y + dy[i];
					int zz = temp.z + dz[i];

					if(xx >= 0 && xx < M
						&& yy >= 0 && yy < N
						&& zz >= 0 && zz < H
						&& box[zz][yy][xx] == 0
						&& !visited[zz][yy][xx]) {
						box[zz][yy][xx] = 1;
						nextQueue.add(new Node(xx, yy, zz));
						num++;
						visited[zz][yy][xx] = true;
					}
				}
			}
			day++;
		}

		if(num != total) {
			System.out.println("-1");
			return;
		}

		System.out.println(day-1);
	}

	static class Node {
		int x;
		int y;
		int z;
		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
