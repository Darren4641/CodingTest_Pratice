package Backjoon.April;

import java.io.*;

public class 숫자1로만들기 {


    public static int solution(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <=num; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 ==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        return dp[num];
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solution(num)));
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
