import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] channels = new String[N];
        int kbs1Index = 0;
        int kbs2Index = 0;
        for(int i=0; i<N; i++) {
            channels[i] = br.readLine();
            if(channels[i].equals("KBS1")) {
                kbs1Index = i;
            } else if(channels[i].equals("KBS2")) {
                kbs2Index = i;
            }
        }

        if(kbs2Index < kbs1Index) {
            kbs2Index++;
        }

        for(int i=0; i<kbs1Index; i++) {
            bw.append("1");
        }
        for (int i=0; i<kbs1Index; i++) {
            bw.append("4");
        }
        for(int i=0; i<kbs2Index; i++) {
            bw.append("1");
        }
        for (int i=1; i<kbs2Index; i++) {
            bw.append("4");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
