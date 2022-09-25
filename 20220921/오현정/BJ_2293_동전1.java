package Baekjoon;

import java.util.Scanner;

public class BJ_2293_동전1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n+1];
		int[] dp = new int[k+1];
		for(int i=1;i<=n;i++) {
			coin[i] = sc.nextInt();
		}
		dp[0] = 1; // 1원으로 1원을 표현할 수 있는 경우의 수, 2원으로 2원을 표현할 수 있는 경우의 수, 5원으로 5원을 표현할 수 있는 경우의 수는 모두 1가지
		for(int i=1;i<=n;i++) {  // 코인 가지수
			for(int j=coin[i];j<=k;j++) { // coin[i]보다 작은 경우는 coin[i]로 나타낼 수 없으므로, coin[i]부터 시작
				dp[j] = dp[j]+dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
