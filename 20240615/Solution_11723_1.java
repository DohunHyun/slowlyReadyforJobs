import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_11723_1 { // 다른 풀이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int[] S = new int[21];

        while(M > 0) {
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            String action = input.split(" ")[0];
            int number = 0;
            if(inputArray.length > 1) {
                number = Integer.parseInt(input.split(" ")[1]);
            }

            switch (action) {
                case "add":
                    S[number] = 1;
                    break;

                case "remove":
                    if(S[number] != 0) {
                        S[number] = 0;
                    }
                    break;

                case "check":
                    if(S[number] == 0) {
                        bw.write("0\n");
                    } else if(S[number] == 1) {
                        bw.write("1\n");
                    }
                    break;

                case "toggle":
                    if(S[number] == 0) {
                        S[number] = 1;
                    } else if(S[number] == 1) {
                        S[number] = 0;
                    }
                    break;

                case "all":
                    for(int i=1; i<S.length; i++) {
                        S[i] = 1;
                    }
                    break;

                case "empty":
                    S = new int[21];
                    break;
            }
            M--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}