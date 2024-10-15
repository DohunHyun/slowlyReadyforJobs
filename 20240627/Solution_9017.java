import java.io.*;
import java.util.HashMap;

public class Solution_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] orders = new int[N];
            HashMap<Integer, Integer> teamSet = new HashMap();

            String[] split = br.readLine().split(" ");
            int maxTeam = 0; // 팀 번호 최대값
            for(int i=0; i<split.length; i++) {
                int temp = Integer.parseInt(split[i]);
                teamSet.put(temp, teamSet.getOrDefault(temp, 0) + 1);
                orders[i] = temp;
                if(maxTeam < temp) {
                    maxTeam = temp;
                }
            }
            int[] fifthPlayer = new int[maxTeam + 1];
            HashMap<Integer, Integer> scoreMap = new HashMap<>();
            HashMap<Integer, Integer> temp = new HashMap<>();
            int score = 1;
            for(int order : orders) {
                if(teamSet.get(order) == 6) {
                    temp.put(order, temp.getOrDefault(order, 0) + 1);

                    if(temp.get(order) <= 4) {
                        scoreMap.put(order, scoreMap.getOrDefault(order, 0) + score);
                    }

                    if(temp.get(order) == 5) {
                        fifthPlayer[order] = score;
                    }
                    score++;
                }
            }

            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            int answer = 0;

            for(Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);
                if(tmp < result) {
                    result = tmp;
                    fifthScore = fifthPlayer[key];
                    answer = key;
                } else if(tmp == result) {
                    if(fifthScore > fifthPlayer[key]) {
                        answer = key;
                    }
                }
            }

            System.out.println(answer);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
