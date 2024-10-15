import java.io.*;

public class Solution_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int size = input.length();
        int cntZero = 0;
        int cntOne = 0;
        int cnt = 0;
        for(int i=0; i<size; i++) {
            if(input.charAt(i) == '0') {
                cntZero++;
            } else if(input.charAt(i) == '1') {
                cntOne++;
            }
        }

        for(int i=input.length()-1; cnt < cntZero/2; i--) {
            if(input.charAt(i) == '0') {
                cnt++;

                // 이부분 0을 빼고 다시 만든다. 0001110 0 1
                input = input.substring(0, i) + input.substring(i+1, input.length());
            }
        }
        cnt = 0;
        for(int i=0; cnt < cntOne/2; i++) {
            if(input.charAt(i) == '1') {
                cnt++;

                // 이부분 1을 빼고 다시 만든다.
                input = input.substring(0, i) + input.substring(i+1, input.length());
                i--;
            }
        }

        bw.write(input);
        bw.flush();
        bw.close();
        br.close();
    }
}
