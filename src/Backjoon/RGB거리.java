package Backjoon;

import java.io.*;
import java.util.*;

public class RGB거리 {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public static int solution(int[][] house, int size) {
        int[][] dp = new int[size][3];
        dp[0][RED] = house[0][RED];
        dp[0][GREEN] = house[0][GREEN];
        dp[0][BLUE] = house[0][BLUE];


        for(int i = 1; i < size; i++) {
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + house[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + house[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + house[i][BLUE];
        }

        return Math.min(Math.min(dp[size - 1][RED], dp[size - 1][GREEN]), dp[size - 1][BLUE]);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            int[][] house = new int[size][3];
            StringTokenizer st;
            for(int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 3; j++) {
                    house[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write(String.valueOf(solution(house, size)));
            bw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
