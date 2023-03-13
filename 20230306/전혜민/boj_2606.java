package BOJ;

import java.util.Scanner;

public class boj_2606 {
	
	static private int n, m, result;
	static private int[][] map = new int[101][101];
	static private boolean[] visit;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[101];
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		find(1);
		System.out.println(result);
	}
	
	private static void find(int start) {
		visit[start] = true;
		
		for(int i = 1; i <= n; i++) {
			if(map[start][i] == 1 && !visit[i]) {
				result++;
				find(i);
			}
		}
	}

}
