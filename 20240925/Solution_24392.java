import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_24392 {
    static int N, M, answer;
    static int[][] map, dp;
    static boolean[][] visited;
//    static int[] dr = {}; // 위로만 가니까 의미 없음
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        dp = new int[N][M];
        answer = 0;

        for(int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<M; i++) {
            if(map[0][i] == 0) {
                continue;
            }
            answer += dp(0, i);
            answer %= 1000000007;
        }

        System.out.println(answer);

    }

    static int dp(int r, int c) {
        if(r == N-1) {
            return 1;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int result = 0;

        for(int i=-1; i<=1; i++) {
            int rr = r + 1;
            int cc = c + i;
            if(cc>=0 && cc<M && map[rr][cc]==1) {
                result += dp(rr, cc);
                result %= 1000000007;
            }
        }
        dp[r][c] = result;
        return result;
    }
}
