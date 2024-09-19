import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println("0");
            return;
        }
        int[] map = new int[N];
        int[] dp = new int[N];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(split[i]);
        }

        dp[0] = 0;

        for(int i=0; i<N; i++) {
            int r = map[i]; // 다음 칸 까지 갈수있는 범위
            if(i != 0 && dp[i] == 0) {
                continue;
            }
            for(int j=1; j<=r; j++) {
                if(i+j < N && (dp[i+j] == 0 || dp[i+j] > dp[i]+1)) {
                    dp[i+j] = dp[i]+1;
                }
            }
        }

        if(dp[N-1] != 0) {
            System.out.println(dp[N-1]);
        } else {
            System.out.println("-1");
        }
    }
}
