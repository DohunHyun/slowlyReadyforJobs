import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1987 {
    static int R, C, answer;
    static String[][] map;
    static boolean[] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        map = new String[R][C];
        visited = new boolean[26];
        answer = 0;

        for(int i=0; i<R; i++) {
            split = br.readLine().split("");
            for(int j=0; j<C; j++) {
                map[i][j] = split[j];
            }
        }

//        bfs();
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int r, int c, int depth) {
        visited[map[r][c].charAt(0) - 'A'] = true;
        answer = Math.max(answer, depth);

        for(int i=0; i<4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if(rr>=0 && rr<R && cc>=0 && cc<C && !visited[stringToInt(map[rr][cc])]) {
                dfs(rr, cc, depth+1);
            }
        }
        visited[map[r][c].charAt(0) - 'A'] = false;
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visited[stringToInt(map[0][0])] = true;
        queue.add(new Node(0, 0, map[0][0], 1));
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(answer < temp.sum) {
                answer = temp.sum;
            }

            for(int i=0; i<dr.length; i++) {
                int rr = temp.r + dr[i];
                int cc = temp.c + dc[i];
                if(rr>=0 && rr<R && cc>=0 && cc<C && !visited[stringToInt(map[rr][cc])]) {
                    queue.add(new Node(rr, cc, map[rr][cc], temp.sum+1));
                    visited[stringToInt(map[rr][cc])] = true;
                }
            }
        }
    }

    static int stringToInt(String s) {
        char stc = s.charAt(0);
        int index = stc - 'A';
        return index;
    }

    static class Node {
        int r;
        int c;
        String alphabet;
        int sum;

        Node(int r, int c, String alphabet, int sum) {
            this.r = r;
            this.c = c;
            this.alphabet = alphabet;
            this.sum = sum;
        }
    }
}
