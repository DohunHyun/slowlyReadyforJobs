import java.util.Scanner;

public class Solution_2644 {
	static int N; // 사람 수
	static int X, Y; // 대상 사람
	static int M; // 관계 개수
	static int[][] array; // 부모 자식 관계 배열
	static int[] visited; // 방문여부
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		M = sc.nextInt();
		array = new int[N+1][N+1];
		visited = new int[N+1];
		answer = -1;

		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			array[x][y] = 1;
		}
		visited[X] = 1;
		find(X, 0);

		System.out.println(answer);
	}

	private static void find(int start, int count) {
		// 종료 조건
		if(start == Y) {
			answer = count;
			return;
		}

		for(int i=0; i<array.length; i++) {
			if(visited[i] == 0
				&& (array[start][i] == 1 || array[i][start] == 1) ) {
				visited[i] = 1;
				find(i, count+1);
			}
		}
		return;
	}
}
