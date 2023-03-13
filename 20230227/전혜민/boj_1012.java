package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1012 {
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, 1, 0, -1};
	public static int M, N;
	public static int map[][];
	public static boolean visit[][];
	public static int result = 0;
	public static Queue<String> queue = new LinkedList<String>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			
			map = new int[N][M];
			visit = new boolean[N][M];
			result = 0;
			
			for(int k = 0; k < K; k++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				map[n][m] = 1;
				queue.add(n + "," + m);
			}
			
			while(!queue.isEmpty()) {
				String xy = queue.poll();
				int x = Integer.parseInt(xy.split(",")[0]);
				int y = Integer.parseInt(xy.split(",")[1]);
				
				if(!visit[x][y]) {
					find(x, y);
					result++;
				}
			}
			System.out.println(result);
			
		}
	}	
	public static void find(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
			if(map[nx][ny] == 1) {
				find(nx, ny);
			}
		}
	}

}


/*
 * 
 * 1. 배추가 있는 자리를 모두 큐에 담는다
 * 2. 큐에 있는 자리를 하나씩 빼온다
 * 3. 인접한 곳에 배추가 있는지 확인한다
 * 4. 없으면 +1
 * 5. 있으면 이동한다 
 */