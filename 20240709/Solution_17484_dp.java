import java.io.*;
import java.util.Arrays;

public class Solution_17484_dp {
    static int N, M, answer;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        dp = new int[N][M][3];

        for(int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i=0; i<M; i++) {
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
            dp[0][i][2] = map[0][i];
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(j==0) { // 왼쪽 끝일때
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + map[i][j];
                } else if(j==M-1) { // 오른쪽 끝일때
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j][2] + map[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j];
                }
            }
        }

        answer = Integer.MAX_VALUE;
        for(int i=0; i<M; i++) {
            for(int j=0; j<3; j++) {
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        System.out.println(answer);
    }
}
