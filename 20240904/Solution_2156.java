import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = array[0];
        for(int i=1; i<n; i++) {
            if(i == 1) {
                dp[1] = array[0] + array[1];
                continue;
            }
            if(i == 2) {
                dp[2] = Math.max(dp[1], Math.max(array[0] + array[2], array[1] + array[2]));
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + array[i], dp[i-3] + array[i-1] + array[i]));
        }

        System.out.println(dp[n-1]);


    }
}
