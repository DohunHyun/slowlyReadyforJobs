package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606_바이러스 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 컴퓨터 수
		int conN = sc.nextInt(); // 연결된 네트워크수
		boolean visited[] = new boolean[N+1];
		boolean network[][] = new boolean[N+1][N+1];
		int answer = 0;
		
		for(int i=1;i<conN+1;i++) { // 연결된 네트워크 체크
			int r = sc.nextInt();
			int c = sc.nextInt();
			network[r][c] = true;
			network[c][r] = true;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		//1번 컴퓨터 바이러스 걸림
		visited[1] = true;
		for(int i=1;i<N+1;i++) {
			if(network[1][i]==true) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int nc = que.poll(); // 다음 바이러스 걸릴 컴퓨터
			if(visited[nc]==true) continue; // 이미 방문한 컴퓨터면 pass
			visited[nc] = true; // 방문체크
			answer++;
			for(int i=1;i<N+1;i++) {
				if(visited[i]==false&&network[nc][i]==true) que.add(i);
			}
		}
		
		System.out.println(answer);
	}
}