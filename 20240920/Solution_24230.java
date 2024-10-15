import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_24230 {
    static int N, answer;
    static ArrayList<Integer>[] list;
    static int[] colors;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = 0;
        list = new ArrayList[N+1];
        colors = new int[N+1];
        visited = new boolean[N+1];

        String[] split = br.readLine().split(" ");
        for(int i=1; i<N+1; i++) {
            colors[i] = Integer.parseInt(split[i-1]);
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            list[a].add(b);
            list[b].add(a);
        }

        visited[1] = true;
        if(colors[1] != 0) {
            answer++;
        }
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int index) {
        for(int i=0; i<list[index].size(); i++) {
            int temp = list[index].get(i);
            if(!visited[temp]) {
                visited[temp] = true;
                if(colors[index] != colors[temp]) {
                    answer++;
                }
                dfs(temp);
            }
        }
    }
}
