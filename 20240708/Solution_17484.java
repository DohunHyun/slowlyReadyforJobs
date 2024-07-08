import java.io.*;

public class Solution_17484 {
    static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        answer = Integer.MAX_VALUE;

        for(int i=0; i<M; i++) {
            dfs(0, i, -1, 0);
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c, int d, int sum) {
        if(r == N) {
            answer = Math.min(answer, sum);
            return;
        }
        for(int i=0; i<3; i++) {
            if(d == i) continue;

            int nx = c + dx[i];
            if(nx >= 0 && nx < M) {
                dfs(r+1, nx, i, sum + map[r][c]);
            }
        }
    }
}
