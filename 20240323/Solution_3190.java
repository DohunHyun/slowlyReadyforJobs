package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 0, 1, 0}; // 위 오 아 왼
        int[] dy = {0, 1, 0, -1};
        int direction = 1; // 초기값 오른쪽

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        map[0][0] = 1;

        Node headNode = new Node(0, 0);
        Node tailNode = new Node(0, 0);
        Node startNode = new Node(0, 0, tailNode, headNode);
        headNode.nextNode = startNode;
        tailNode.prevNode = startNode;

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            String line = br.readLine();
            int x = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);

            map[x-1][y-1] = 2; // 사과 표시
        }

        int L = Integer.parseInt(br.readLine());
        String[][] inputdirection = new String[L][2];

        for(int i=0; i<L; i++) {
            String line = br.readLine();
            inputdirection[i][0] = line.split(" ")[0]; // 시간
            inputdirection[i][1] = line.split(" ")[1]; // 방향
        }
        int changeIndex = 0; // 방향 바뀔때 다음 값.
        int time = 0;

        while(time >= 0) {
            time++;

            // 이동할 위치
            int moveX = headNode.nextNode.x + dx[direction];
            int moveY = headNode.nextNode.y + dy[direction];

            // 종료조건
            if(moveX >= N || moveX < 0 || moveY >= N || moveY < 0
                    || map[moveX][moveY] == 1) {
                break;
            }

            // 이동
            if(map[moveX][moveY] == 2) { // 사과가 있을때,
                // 머리 전진
                map[moveX][moveY] = 1;
                Node newHeadNode = new Node(moveX, moveY, headNode.nextNode, headNode);
                headNode.nextNode.prevNode = newHeadNode;
                headNode.nextNode = newHeadNode;
            } else if(map[moveX][moveY] == 0) {
                // 머리 전진
                map[moveX][moveY] = 1;
                Node newHeadNode = new Node(moveX, moveY, headNode.nextNode, headNode);
                headNode.nextNode.prevNode = newHeadNode;
                headNode.nextNode = newHeadNode;

                // 꼬리 자르기
                map[tailNode.prevNode.x][tailNode.prevNode.y] = 0;
                tailNode.prevNode = tailNode.prevNode.prevNode;
                tailNode.prevNode.nextNode = tailNode;
            }

            // input에 시간에 방향 변환
            if(Integer.parseInt(inputdirection[changeIndex][0]) == time) {
                if(inputdirection[changeIndex][1].equals("L")) {
                    direction--;
                    if(direction<0) {
                        direction = 3;
                    }
                } else if(inputdirection[changeIndex][1].equals("D")) {
                    direction++;
                    if(direction>3) {
                        direction = 0;
                    }
                }
                if(changeIndex < L-1) {
                    changeIndex++;
                }
            }
        }

        System.out.println(time);
    }

    static class Node {
        int x;
        int y;
        Node nextNode;
        Node prevNode;

        Node(int x, int y, Node nextNode, Node prevNode) {
            this.x = x;
            this.y = y;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}