import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1577 {
    static int N, M, K;
    static long[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(br.readLine());

        map = new long[N+1][M+1];

        int[][] horizontal = new int[N][M+1];
        int[][] vertical = new int[N+1][M];

        for(int i=0; i<K; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            int d = Integer.parseInt(split[3]);

            if(a == c) {
                vertical[a][Math.min(b, d)] = 1;
            } else {
                horizontal[Math.min(a, c)][b] = 1;
            }
        }

        for(int i=1; i<M+1; i++) {
            if(vertical[0][i-1] == 1) break;
            map[0][i] = 1;
        }

        for(int i=1; i<N+1; i++) {
            if(horizontal[i-1][0] == 1) break;
            map[i][0] = 1;
        }

        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[0].length; j++) {
                map[i][j] = map[i][j-1] + map[i-1][j];

                if(horizontal[i-1][j] == 1) {
                    map[i][j] -= map[i-1][j];
                }

                if(vertical[i][j-1] == 1) {
                    map[i][j] -= map[i][j-1];
                }
            }
        }
        System.out.println(map[N][M]);
    }
}
