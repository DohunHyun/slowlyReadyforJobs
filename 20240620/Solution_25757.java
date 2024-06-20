import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> hashSet = new HashSet<>();

        String[] split = br.readLine().split(" ");
        String game = split[1];
        int number = Integer.parseInt(split[0]);

        for(int i=0; i<number; i++) {
            hashSet.add(br.readLine());
        }

        if(game.equals("Y")) {
            System.out.println(hashSet.size());
        } else if(game.equals("F")) {
            System.out.println(hashSet.size()/2);
        } else if(game.equals("O")) {
            System.out.println(hashSet.size()/3);
        }
    }
}