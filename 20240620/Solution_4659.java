import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList arrayList = new ArrayList();
        String[] mo = {"a", "e", "i", "o", "u"};
        List<String> moList = new ArrayList<>(Arrays.asList(mo));

        while(true) {
            String input = br.readLine();
            if(input.equals("end")) {
                break;
            }

            String[] split = input.split("");
            boolean rule1 = false;
            boolean rule2 = true;
            boolean rule3 = true;
            int rule2CntJa = 0;
            int rule2CntMo = 0;
            String prevChar = "";

            for(int i=0; i< split.length; i++) {
                // rule1
                if(moList.contains(split[i])) {
                    rule1 = true;
                }

                // rule2
                if(moList.contains(split[i])) {
                    rule2CntMo++;
                    rule2CntJa = 0;
                    if(rule2CntMo >= 3) {
                        rule2 = false;
                        break;
                    }
                } else {
                    rule2CntJa++;
                    rule2CntMo = 0;
                    if(rule2CntJa >= 3) {
                        rule2 = false;
                        break;
                    }
                }

                // rule3
                if(prevChar.equals(split[i])) {
                    if(!(split[i].equals("e") || split[i].equals("o"))) {
                        rule3 = false;
                        break;
                    }
                }
                prevChar = split[i];
            }

            if(rule1 && rule2 && rule3) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }
}