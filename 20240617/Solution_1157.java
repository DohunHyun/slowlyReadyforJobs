import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String input = br.readLine();

        int[] count = new int[91];

        char[] chars = input.toCharArray();

        for(int i=0; i<chars.length; i++) {
            int temp = Integer.valueOf(chars[i]);
            if(temp > 96) {
                temp -= 32;
            }
            count[temp]++;
        }
        int max = 0;
        int duplicate = 0;
        int index = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                index = i;
                duplicate = 0;
                continue;
            }
            if(count[i] == max) {
                duplicate = 1;
            }
        }

        if(duplicate == 1) {
            System.out.println("?");
        } else {
            char letter = (char)index;
            System.out.println(letter);
        }

    }
}