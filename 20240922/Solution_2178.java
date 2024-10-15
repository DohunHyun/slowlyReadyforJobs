import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2178 {
    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            split = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        visited[0][0] = true;
//        dfs(0, 0, 1);
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.r == N-1 && temp.c == M-1) {
                answer = temp.cnt;
                return;
            }

            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr >= 0 && rr < N && cc >= 0 && cc < M
                        && !visited[rr][cc] && map[rr][cc] == 1) {
                    visited[rr][cc] = true;
                    queue.add(new Node(rr, cc, temp.cnt+1));
                }
            }
        }
    }

    static class Node {
        int r, c, cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static void dfs(int r, int c, int cnt) {
        if(r == N-1 && c == M-1) {
            if(answer > cnt) {
                answer = cnt;
            }
            return;
        }

        for(int i=0; i<dr.length; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];

            if(rr >= 0 && rr < N && cc >= 0 && cc < M
             && !visited[rr][cc] && map[rr][cc] == 1) {
                visited[rr][cc] = true;
                dfs(rr, cc, cnt+1);
                visited[rr][cc] = false;
            }
        }
    }
}
