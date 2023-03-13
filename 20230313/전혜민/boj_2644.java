package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_2644 {
	static ArrayList<Integer>[] parent;
	static boolean[] visit;
	static int result = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		parent = new ArrayList[n+1];
		for(int k = 1; k <= n; k++) {
			parent[k] = new ArrayList<>();
		}
		visit = new boolean[n+1];
		
		int m = sc.nextInt();
		for(int k = 0; k < m; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			parent[x].add(y);
			parent[y].add(x);
		}
		
		find(i, j, 0);
		System.out.println(result);
	}
	
	private static void find(int start, int end, int cnt) {
		visit[start] = true;
		
		if(start == end) {
			result = cnt;
			return;
		}
		
		for(int i = 0; i < parent[start].size(); i++) {
			int nx = parent[start].get(i);
			if(!visit[nx]) {
				find(nx, end, cnt+1);
			}
		}
	}

}
