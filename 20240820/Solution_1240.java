import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1240 {
    static int N, M;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        while (M > 0) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            visited = new boolean[N+1];
            bfs(a, b);
            M--;
        }
    }

    static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.number == end) {
                System.out.println(temp.dist);
                return;
            }

            for(Node next : graph[temp.number]) {
                if(!visited[next.number]) {
                    visited[next.number] = true;
                    queue.add(new Node(next.number, temp.dist + next.dist));
                }
            }
        }
    }

    static class Node {
        int number;
        int dist;

        public Node(int number, int dist) {
            this.number = number;
            this.dist = dist;
        }
    }
}
