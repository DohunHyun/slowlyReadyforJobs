import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        int[] dp = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        dp[0] = array[0];
        int max = array[0];
        for(int i=1; i<N; i++) {
            dp[i] = Math.max(array[i], dp[i-1] + array[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
