import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static int[][] visited; // 방문한 순서 기록
    static int[] dx = {-1, 0, 1, 0}; // 위 오 아 왼
    static int[] dy = {0, 1, 0, -1};
    static int secondX = 0, secondY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSize = br.readLine().split(" ");
        N = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);
        map = new int[N][M];
        visited = new int[N][M];
        answer = 0;

        for(int i=0; i<N; i++) {
            String[] inputMap = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(inputMap[j]);
            }
        }

        // 타입이 총 1-2개, 2-1개, 3-8개, 4-4개, 5-4개 >> 19가지
        // ㅗ 모양 말고는 길이가 4인 dfs를 하면 된다.
        // 그럼 ㅗ 모양은? 길이가 3 까지만 그리고 그 그린 애들에서 뻗어나가서 1개만 그리면 되지않나?
        // 전체를 그런 방식으로 했을때 시간초과가 되지 않을까 만약 된다면 ㅗ 모양만 따로 탐색을 한다.
        // 역시나 시간초과. 그럼 어떻게하지?
        // 두번째에 방문한곳을 저장해서 쓰자.

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = 1;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = 0;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if(cnt == 4) {
            if(sum > answer) {
                answer = sum;
            }
            return;
        } else if(cnt == 3) {
            for(int k=0; k<dx.length; k++) {
                int ii = secondX + dx[k];
                int jj = secondY + dy[k];
                if(ii>=0 && ii<N && jj>=0 && jj<M && visited[ii][jj]==0) {
                    visited[ii][jj] = 4;
                    dfs(ii, jj, cnt+1, sum+map[ii][jj]);
                    visited[ii][jj] = 0;
                }
            }
        }

        for(int i=0; i<dx.length; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx >= 0 && xx < N && yy >= 0 && yy < M && visited[xx][yy]==0) {
                visited[xx][yy] = cnt+1;
                if(cnt+1 == 3) {
                    secondX = x;
                    secondY = y;
                }
                dfs(xx, yy, cnt+1, sum+map[xx][yy]);
                visited[xx][yy] = 0;
            }
        }
    }

}
