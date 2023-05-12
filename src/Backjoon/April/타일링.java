package Backjoon.April;

import java.io.*;

public class 타일링 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[1001];

            dp[0] = 1;
            dp[1] = 2;
            for(int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
            bw.write(String.valueOf(dp[n-1]));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
