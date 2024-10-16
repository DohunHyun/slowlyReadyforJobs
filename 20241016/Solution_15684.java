import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_15684 {
    static int N, M, H;
    static int[][] map;
    static int answer;
    static boolean finish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        H = Integer.parseInt(split[2]);

        map = new int[H+1][N+1];

        if(M > 0) {
            for(int i=0; i<M; i++) {
                split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]); // 가로선 위치
                int b = Integer.parseInt(split[1]); // 세로선 기준, +1로 연결
                map[a][b] = 1; // 1은 오른쪽으로 이동
                map[a][b+1] = 2; // 2는 왼쪽으로 이동
            }
        }

        for(int i=0; i<=3; i++) {
            answer = i;
            dfs(i, 0);
            if(finish) break;
        }

        System.out.println(finish ? answer : "-1");

    }
    static void dfs(int x, int count) {
        if(finish) return;
        if(answer == count) {
            if(check()) {
                finish = true;
                return;
            }
        }

        for(int i=x; i<H+1; i++) {
            for(int j=1; j<N; j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i, count+1);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for(int i=1; i<=N; i++) {
            int x = 1; // 검사할곳
            int y = i; // 시작하는 위치, 현재 위치

            for(int j=0; j<H; j++) { // 차례로 내려오면서
                if(map[x][y] == 1) {
                    y++;
                } else if(map[x][y] == 2) {
                    y--;
                }
                x++;
            }
            if(y != i) { // 현재위치와 시작점 위치가 같은지 확인
                return false;
            }
        }
        return true;
    }
}
