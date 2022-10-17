import java.util.*;
public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		int pre = -1;
		for(int i = 1; i <= N; i++) {
			int now = sc.nextInt();
			if(pre == -1 && now == 0) {
				pre = 0;
				dp[i] = 1;
			}else {
				if((pre + 1) % 3 == now) {
					dp[i] = dp[i-1] + 1;
					pre = now;
				}else {
					dp[i] = dp[i-1];
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
