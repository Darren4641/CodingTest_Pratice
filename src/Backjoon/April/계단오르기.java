package Backjoon.April;

import java.io.*;

public class 계단오르기 {

    public static int solution(int[] floor) {
        int[] dp = new int[floor.length];


        if(floor.length == 1) return floor[0];
        else if(floor.length == 2) return floor[0] + floor[1];
        else if(floor.length == 3) return Math.max(floor[0] + floor[2], floor[1] + floor[2]);
        else {
            dp[0] = floor[0];
            dp[1] = floor[0] + floor[1];
            dp[2] = Math.max(floor[0] + floor[2], floor[1] + floor[2]);

            for(int i = 3; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 3] + floor[i - 1], dp[i - 2]) + floor[i];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            int[] floor = new int[size];
            for(int i = 0; i < size; i++) {
                floor[i] = Integer.parseInt(br.readLine());
            }

            bw.write(String.valueOf(solution(floor)));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
