import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            int first = Integer.parseInt(input.split(" ")[0]);
            int second = Integer.parseInt(input.split(" ")[1]);
            int third = Integer.parseInt(input.split(" ")[2]);

            List array = new ArrayList();
            array.add(first);
            array.add(second);
            array.add(third);
            Collections.sort(array);

            if(first == 0 && second == 0 && third == 0) {
                break;
            }

            if((int)array.get(0) + (int)array.get(1) <= (int)array.get(2)) {
                System.out.println("Invalid");
            } else if(first == second && first == third) {
                System.out.println("Equilateral");
            } else if(first == second || second == third || first == third) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}