import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_11724 {
    static int answer = 0;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        visited = new boolean[N];
        answer = 0;

        for(int i=0; i<N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            arrayList.get(Integer.parseInt(split[0])-1).add(Integer.parseInt(split[1])-1);
            arrayList.get(Integer.parseInt(split[1])-1).add(Integer.parseInt(split[0])-1);
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(arrayList, i);
            }
        }

        System.out.println(answer);
    }

    // index랑 연결되어있는것들 다 true로 만들기
    static void dfs(ArrayList<ArrayList<Integer>> arrayList, int index) {
        ArrayList<Integer> tempList = arrayList.get(index);

        // templist 에 있는 인덱스들을 다 true로 바꾸고 걔안에 들어있는 애들도 다해준다.
        for(int temp : tempList) {
            if(!visited[temp]) {
                visited[temp] = true;
                dfs(arrayList, temp);
            }
        }
    }
}
