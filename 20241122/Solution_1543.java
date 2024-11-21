import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] document = br.readLine().split("");
        String[] word = br.readLine().split("");
        int answer = 0;

        for(int i = 0; i < document.length; i++) {
            if(word[0].equals(document[i])) {
                boolean isContain = true;
                for(int j = 1; j < word.length; j++) {

                    if(i+j >= document.length || !word[j].equals(document[i+j])) {
                        isContain = false;
                        break;
                    }
                }
                if(isContain) {
                    answer++;
                    i += word.length - 1;
                }
            }
        }
        System.out.println(answer);
    }
}
