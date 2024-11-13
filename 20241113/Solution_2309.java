import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int sum = 0;
                for(int k=0; k<9; k++) {
                    if(k == i || k == j) {
                        continue;
                    }
                    sum += list.get(k);
                }
                if(sum == 100) {
                    for(int k=0; k<9; k++) {
                        if(k != i && k != j) {
                            System.out.println(list.get(k));
                        }
                    }
                    return;
                }
            }
        }
    }
}
