import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_16931 {
    static int N, M;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        answer = 0;

        for(int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                check(i, j);
            }
        }

        System.out.println(answer);
    }

    static void check(int r, int c) {
        // map에 i,j 위치의 겉넓이를 구하면 됨

        // 일단 윗면 아랫면은 해당 칸에 1 이상만 있으면 +2를 하면됨.
        if(map[r][c] > 0) {
            answer += 2;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];

            // 옆에 아무도 없거나 -> 높이에 따라서 체크해야함
            if(rr >= 0 && rr < N && cc >= 0 && cc < M) {
                if(map[r][c] < map[rr][cc]) {
                    // 옆이 나보다 높이가 높다
                    // 그럼 그쪽 면은 색칠할 필요없음.
                } else if(map[r][c] == map[rr][cc]) {
                    // 옆이 높이가 같다
                    // 여기도
                } else {
                    // 옆이 나보다 높이가 낮다
                    // 차이만큼만 칠해주면 된다.
                    answer += map[r][c] - map[rr][cc];
                }
            } else {
                // 범위 밖이면 +높이 하면됨
                answer += map[r][c];
            }

        }
    }
}
