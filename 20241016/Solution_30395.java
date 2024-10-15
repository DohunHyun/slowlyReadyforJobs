import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_30395 {
    static int answer, N;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        answer = 0;

        String[] split = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        int stop = 0;
        int count = 0;
        for(int i=0; i<N; i++) {
            if(stop > 0) {
                stop--;
            }
            if(array[i] == 0) { // 끊겨야할때
                if(stop == 0) { // 아이템 있으면
                    stop = 2; // 턴수 체크해주고
                } else { // 아이템 없으면
                    if(count > answer) {
                        answer = count;
                    }
                    count = 0;
                }
            } else { // 그냥 문제 풀었을때
                count++;
            }
        }
        if(count > answer) {
            answer = count;
        }
        System.out.println(answer);
    }
}
