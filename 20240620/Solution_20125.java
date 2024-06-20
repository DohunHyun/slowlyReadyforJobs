import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[][] map = new String[N][N];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split("");
        }

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int heartX = 0;
        int heartY = 0;

        // 심장찾기
        for(int i=0; i<N; i++) {
            if(heartX != 0) break;
            for(int j=0; j<N; j++) {
                if(map[i][j].equals("*")) {
                    heartX = i+1;
                    heartY = j;
                    break;
                }
            }
        }

        // 왼쪽 팔
        for(int i=heartY-1; i>=0; i--) {
            if(map[heartX][i].equals("*")) {
                leftArm++;
            } else {
                break;
            }
        }

        // 오른쪽 팔
        for(int i=heartY+1; i<N; i++) {
            if(map[heartX][i].equals("*")) {
                rightArm++;
            } else {
                break;
            }
        }

        // 허리
        for(int i=heartX+1; i<N; i++) {
            if(map[i][heartY].equals("*")) {
                waist++;
            } else {
                break;
            }
        }

        // 왼쪽 다리
        for(int i=heartX+waist+1; i<N; i++) {
            if(map[i][heartY-1].equals("*")) {
                leftLeg++;
            } else {
                break;
            }
        }

        // 오른쪽 다리
        for(int i=heartX+waist+1; i<N; i++) {
            if(map[i][heartY+1].equals("*")) {
                rightLeg++;
            } else {
                break;
            }
        }
        System.out.println((heartX+1) + " " + (heartY+1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}