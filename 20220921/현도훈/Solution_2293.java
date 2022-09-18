import java.util.Scanner;

public class Solution {
	static int k;
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		k = sc.nextInt();
		coin = new int[101];
		dp = new int[10001];

		for(int i=1; i<=n; i++) {
			coin[i] = sc.nextInt();
		}

		dp[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
