package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numberOfPeople = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            numberOfPeople[i] = Integer.parseInt(input[i]);
        }

        String[] BC = br.readLine().split(" ");
        int B = Integer.parseInt(BC[0]);
        int C = Integer.parseInt(BC[1]);

        long answer = 0;

        // 총감독관은 방마다 1명. B만큼 관리 가능.
        // 부감독관은 제한없음. C명 관리 가능.
        for(int i=0; i<N; i++) {
            int amount = numberOfPeople[i];
            answer++;
            amount -= B;
            if(amount <= 0) continue;
            answer += amount/C;
            if(amount%C != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}