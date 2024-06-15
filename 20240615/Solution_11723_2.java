import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int S = 0;

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
                    S = S | (1 << number);
                    break;

                case "remove":
                    S = S & ~(1 << number);
                    break;

                case "check":
                    int temp = S & (1 << number);
                    if(temp > 0) {
                        bw.write("1\n");
                    } else if(temp == 0) {
                        bw.write("0\n");
                    }
                    break;

                case "toggle":
                    int temp1 = S & (1 << number);
                    if(temp1 > 1) {
                        S = S & ~(1 << number);
                    } else if(temp1 == 0) {
                        S = S | (1 << number);
                    }
                    break;

                case "all":
                    S = S | (1 << 21) - 1;
                    break;

                case "empty":
                    S = 0;
                    break;
            }
            M--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}