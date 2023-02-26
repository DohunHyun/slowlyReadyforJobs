package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1012_유기농배추 {

	static int T, M, N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 우 하 좌
	static int map[][];
	static boolean visited[][];
	static int answer;

	public static class Worm {
		int r, c;

		public Worm(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			M = sc.nextInt(); // 가로(열)
			N = sc.nextInt(); // 세로(행)
			map = new int[N][M];
			visited = new boolean[N][M];
			int K = sc.nextInt();
			for (int k = 0; k < K; k++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = 1;
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && visited[i][j]==false) { // 배추가 있는곳
						bfs(new Worm(i, j));
						answer++;
					}
				}
			}
			System.out.println(answer);

		}
	}

	static Queue<Worm> que = new LinkedList<Worm>();

	public static void bfs(Worm worm) {
		que.add(worm);
		visited[worm.r][worm.c] = true;
		while (!que.isEmpty()) {
			Worm wormQ = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = wormQ.r + dr[d];
				int nc = wormQ.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 1 && visited[nr][nc] == false) {
					que.add(new Worm(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

}
