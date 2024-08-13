import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1012 {
    static int T, M, N, K, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String[] split = br.readLine().split(" ");
            M = Integer.parseInt(split[0]);
            N = Integer.parseInt(split[1]);
            K = Integer.parseInt(split[2]);
            map = new int[M][N];
            visited = new boolean[M][N];
            answer = 0;

            for(int i=0; i<K; i++) {
                split = br.readLine().split(" ");
                map[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        answer++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int i=0; i<dr.length; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if(rr>=0 && rr<M && cc>=0 && cc<N && !visited[rr][cc] && map[rr][cc] == 1) {
                dfs(rr, cc);
            }
        }
    }
}
