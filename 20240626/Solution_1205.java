import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int score = Integer.parseInt(split[1]);
        int P = Integer.parseInt(split[2]);

        ArrayList<Integer> arrayList = new ArrayList();
        if(N != 0) {
            split = br.readLine().split(" ");
        }
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(split[i]));
        }
        Collections.sort(arrayList, Collections.reverseOrder());

        if(N == P && score <= arrayList.get(N-1)) {
            bw.write("-1");
        } else {
            int answer = 1;
            for(int i=0; i<N; i++) {
                if(score < arrayList.get(i)) {
                    answer++;
                } else {
                    break;
                }
            }
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
