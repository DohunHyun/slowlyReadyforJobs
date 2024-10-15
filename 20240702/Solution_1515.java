import java.io.*;

public class Solution_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int pointer = 0;
        int base = 0;
        while(base++ <= 30000) {
            String temp = String.valueOf(base);
            for(int i=0; i<temp.length(); i++) {
                if(temp.charAt(i) == input.charAt(pointer)) {
                    pointer++;
                }
                if(pointer == input.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }

    }
}
