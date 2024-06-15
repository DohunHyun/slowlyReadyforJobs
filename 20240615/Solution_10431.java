import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cycle = Integer.parseInt(br.readLine());

        for(int i=0; i<cycle; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");

            int number = Integer.parseInt(split[0]);
            int[] array = new int[20];
            int count = 0;

            for(int j=0; j<array.length; j++) {
                array[j] = Integer.parseInt(split[j+1]);
            }

            for(int j=1; j<array.length; j++) {
                for(int k=0; k<j; k++) {
                    if(array[j] < array[k]) {
                        count++;
                    }
                }
            }
            bw.write(number + " " + count + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}