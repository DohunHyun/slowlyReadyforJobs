import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_12893 {
    static ArrayList<Integer>[] arrayLists;
    static int[] bipartite;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        arrayLists = new ArrayList[N+1];

        for(int i=1; i<N+1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        bipartite = new int[N+1];

        for(int i=1; i<N+1; i++) {
            if(bipartite[i] != 0) continue; // 이미 처리가 된 부분
            if(!makeBipartite(i, 1)) {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");
    }

    static boolean makeBipartite(int index, int num) {
        if(bipartite[index] != 0) {
            return bipartite[index] == num;
        }

        bipartite[index] = num;
        for(Integer next : arrayLists[index]) {
            if(!makeBipartite(next, (-1) * num)) {
                return false;
            }
        }
        return true;
    }
}
