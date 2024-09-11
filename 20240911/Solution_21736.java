import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_21736 {
    static int N, M, answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new String[N][M];
        visited = new boolean[N][M];
        answer = 0;

        // setting
        int startR = 0, startC = 0;
        for(int i=0; i<N; i++) {
            split = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = split[j];
                if(map[i][j].equals("I")) {
                    startR = i;
                    startC = j;
                }
            }
        }

        // bfs
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(startR, startC));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];

                if(rr >= 0 && rr < N && cc >= 0 && cc < M && !visited[rr][cc]) {
                    if(map[rr][cc].equals("X")) {
                        continue;
                    }
                    if(map[rr][cc].equals("P")) {
                        answer++;
                    }
                    queue.add(new Node(rr, cc));
                    visited[rr][cc] = true;
                }
            }
        }

        if(answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
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
