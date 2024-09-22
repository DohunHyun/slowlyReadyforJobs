import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2468 {
    static int N, answer, max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        answer = 0;
        max = 0;

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        for(int i=0; i<=max; i++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(!visited[r][c] && map[r][c] > i) {
                        bfs(r, c, i);
                        cnt++;
                    }
                }
            }
            if(cnt > answer) {
                answer = cnt;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int r, int c, int height) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr>=0 && rr<N && cc>=0 && cc<N
                        && !visited[rr][cc] && map[rr][cc] > height) {
                    queue.add(new Node(rr, cc));
                    visited[rr][cc] = true;
                }
            }
        }
    }

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
