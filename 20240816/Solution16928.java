import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution16928 {
    static int N, M, answer;
    static int[] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[101];
        visited = new boolean[101];
        answer = 0;

        for(int i=0; i<N+M; i++) {
            split = br.readLine().split(" ");
            map[Integer.parseInt(split[0])] = Integer.parseInt(split[1]);
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            answer++;
            for(int i=0, qSize = queue.size(); i<qSize; i++) {
                int now = queue.poll();

                for(int j=1; j<=6; j++) {
                    int move = now + j;

                    if(move == 100) {
                        return;
                    }
                    if(move > 100) {
                        continue;
                    }

                    if(visited[move]) {
                        continue;
                    }

                    visited[move] = true;
                    if(map[move] > 0) {
                        move = map[move];
                    }
                    queue.add(move);
                }
            }
        }
    }
}
