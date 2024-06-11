import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int H, W, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        H = Integer.parseInt(input.split(" ")[0]);
        W = Integer.parseInt(input.split(" ")[1]);
        N = Integer.parseInt(input.split(" ")[2]);
        M = Integer.parseInt(input.split(" ")[3]);

        int w = (H-1) / (N+1) + 1;
        int h = (W-1) / (M+1) + 1;
        System.out.println(w * h);
    }
}