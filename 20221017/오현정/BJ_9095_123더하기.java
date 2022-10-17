package Baekjoon;

import java.util.Scanner;

public class BJ_9095_123더하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] dp = new int[N+3]; // 런타임 에러 방지
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;			
			if(N<=3) {
				System.out.println(dp[N]);
			}else {
				for(int i=4;i<=N;i++) {
					dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
				}
				System.out.println(dp[N]);
			}
			
		}
	}
}
