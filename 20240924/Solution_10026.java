import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_10026 {
    static int N, answerA, answerB;
    static String[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];
        answerA = 0;
        answerB = 0;

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = split[j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfsColor(i, j);
                }
            }
        }
        System.out.println(answerA + " " + answerB);
    }

    // 색약인 경우
    static void bfsColor(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, map[r][c]));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr>=0 && rr<N && cc>=0 && cc<N && !visited[rr][cc]) {
                    if((temp.color.equals("R") || temp.color.equals("G"))
                            && (map[rr][cc].equals("R") || map[rr][cc].equals("G"))) {
                        // 적록 색약인 경우
                        queue.add(new Node(rr, cc, map[rr][cc]));
                        visited[rr][cc] = true;
                    } else { // 파란색이 껴있는 경우
                        if(temp.color.equals(map[rr][cc])) {
                            queue.add(new Node(rr, cc, map[rr][cc]));
                            visited[rr][cc] = true;
                        }
                    }
                }
            }
        }
        answerB++;
    }

    // 색약이 아닌 경우
    static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, map[r][c]));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr>=0 && rr<N && cc>=0 && cc<N && !visited[rr][cc]) {
                    if(temp.color.equals(map[rr][cc])) {
                        queue.add(new Node(rr, cc, map[rr][cc]));
                        visited[rr][cc] = true;
                    }
                }
            }
        }
        answerA++;
    }

    static class Node {
        int r, c;
        String color;

        Node(int r, int c, String color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
}
