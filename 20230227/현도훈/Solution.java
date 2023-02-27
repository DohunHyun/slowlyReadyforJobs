import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int T, M, N, K, W;
	static int[] dx = {0, 1, 0, -1}; // 위 오 아 왼
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int i=0; i<T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[M][N];
			K = sc.nextInt();
			for(int j=0; j<K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}

			W = 0;
			countWorm(0, 0);
			System.out.println(W);
		}
	}

	private static void countWorm(int x, int y) {
		// 처음 1이면 카운트++, 그리고 그거랑 인접한애들 다 0으로 만들고 전부 순환.
		if(map[x][y] == 1) {
			W++;
			paint(x, y);
		}
		move(x, y);
	}

	// x, y 와 인접한 곳 0으로 칠하기
	private static void paint(int x, int y) {
		map[x][y] = 0;
		for(int i=0; i<dx.length; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx>=0 && xx<M && yy>=0 && yy<N && map[xx][yy] == 1) {
				paint(xx, yy);
			}
		}
	}

	// x, y 에서 다음 칸으로 이동하기.
	private static void move(int x, int y) {
		if(x+1 == M) {
			if(y+1 == N) {
				return;
			}
			x = 0;
			y++;
		} else {
			x++;
		}
		countWorm(x, y);
	}

}
