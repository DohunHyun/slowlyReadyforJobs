import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2206 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int answer;
    static int[] dr = {-1, 0, 1, 0}; // 위 오 아 왼
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        visited = new boolean[N][M][2];
        answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            split = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited[0][0][0] = true;
        bfs();

        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.r == N - 1 && temp.c == M - 1) {
                if(temp.count < answer) {
                    answer = temp.count;
                }
            }

            for(int i=0; i<4; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr >= 0 && rr < N && cc >= 0 && cc < M) {
                    if(map[rr][cc] == 0) { // 벽이 아닐때
                        if(temp.useBreak && !visited[rr][cc][1]) { // 벽을 부순적이 있을때와
                            visited[rr][cc][1] = true;
                            queue.add(new Node(rr, cc, temp.count + 1, temp.useBreak));
                        } else if(!temp.useBreak && !visited[rr][cc][0]) { // 아닐때
                            visited[rr][cc][0] = true;
                            queue.add(new Node(rr, cc, temp.count + 1, temp.useBreak));
                        }
                    } else if(map[rr][cc] == 1 && !temp.useBreak) { // 벽인데 아직 안썼어
                        visited[rr][cc][1] = true;
                        queue.add(new Node(rr, cc, temp.count + 1, true));
                    }
                }
            }
        }
    }

    static class Node {
        int r, c, count;
        boolean useBreak;

        Node(int r, int c, int count, boolean useBreak) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.useBreak = useBreak;
        }
    }
}
