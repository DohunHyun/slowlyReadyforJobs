import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int[] array = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            array[i] = Integer.parseInt(split[i-1]);
        }
        dp[0] = 0;
        for(int i=1; i<=N; i++) {
            dp[i] = dp[i-1] + array[i];
        }

        for(int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            bw.write(dp[b] - dp[a-1] + "\n");
        }
        bw.close();
        br.close();
    }
}
