import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List gearList; // 4개의 톱니가 있는 리스트
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        gearList = new ArrayList<List>();
        for(int i=0; i<4; i++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            // 자료구조 뭐쓰지?
            // 배열? 원형큐? 링크드리스트?
            List list = new LinkedList<Integer>();
            for(int j=0; j<input.length; j++) {
                list.add(input[j]);
            }
            gearList.add(list);
        }

        int K = Integer.parseInt(br.readLine());
        int[][] rotateInput = new int[K][2];
        for(int i=0; i<K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rotateInput[i][0] = input[0];
            rotateInput[i][1] = input[1];
        }

        for(int i=0; i<K; i++) {
            visited = new boolean[gearList.size()];
            visited[rotateInput[i][0]-1] = true;
            rotate(rotateInput[i][0], rotateInput[i][1]);
        }

        score = calcScore();

        System.out.println(score);
    }

    static void rotate(int num, int direction) {
        List gear = (List) gearList.get(num-1);

        if(direction == 1) {
            rotateClockWise(gear, num-1);
        } else if(direction == -1){
            rotateAntiClockWise(gear, num-1);
        }
    }

    static void rotateClockWise(List gear, int gearIndex) {
        boolean left = false, right = false;

        // 내가 돌았을때 양 옆에 영향 주는지 확인.
        // 내가 시계방향 돌면 옆에는 반시계
        // 돌기 전에 맞닿은 부분이 같은 극이면 회전 안하고 다르면 회전.
        if(gearIndex-1 >= 0 && !visited[gearIndex-1]) {
            // 돌기전에 극이 다르면 움직이고, 같으면 움직이지 않는다.
            if(gear.get(6) != ((List)gearList.get(gearIndex-1)).get(2)) {
                left = true;
                visited[gearIndex-1] = true;
            }
        }
        if(gearIndex+1 < gearList.size() && !visited[gearIndex+1]) {
            if(gear.get(2) != ((List)gearList.get(gearIndex+1)).get(6)) {
                right = true;
                visited[gearIndex+1] = true;
            }
        }

        if(left) {
            rotateAntiClockWise((List) gearList.get(gearIndex-1), gearIndex-1);
        }
        if(right) {
            rotateAntiClockWise((List) gearList.get(gearIndex+1),gearIndex+1);
        }
        gear.add(0, gear.remove(7));
    }

    static void rotateAntiClockWise(List gear, int gearIndex) {
        boolean left = false, right = false;

        if(gearIndex-1 >= 0 && !visited[gearIndex-1]) {
            // 돌기전에 극이 다르면 움직이고, 같으면 움직이지 않는다.
            if(gear.get(6) != ((List)gearList.get(gearIndex-1)).get(2)) {
                left = true;
                visited[gearIndex-1] = true;
            }
        }
        if(gearIndex+1 < gearList.size() && !visited[gearIndex+1]) {
            if(gear.get(2) != ((List)gearList.get(gearIndex+1)).get(6)) {
                right = true;
                visited[gearIndex+1] = true;
            }
        }

        if(left) {
            rotateClockWise((List) gearList.get(gearIndex-1), gearIndex-1);
        }
        if(right) {
            rotateClockWise((List) gearList.get(gearIndex+1), gearIndex+1);
        }
        gear.add(7, gear.remove(0));
    }

    static int calcScore() {
        int score = 0;
        for(int i=0; i<gearList.size(); i++) {
            if( (int)((List)gearList.get(i)).get(0) == 1) {
                score += Math.pow(2, i);
            }
        }
        return score;
    }
}