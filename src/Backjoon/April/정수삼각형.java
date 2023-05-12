package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형 {

    public static int solution(int[] num, int size) {
        int[] dp = new int[num.length];

        if(size == 1) return num[1];
        else if(size == 2) return Math.max(num[1] + num[2], num[1] + num[3]);
        else if(num.length == 3) return dp[0] + num[2];
        else {
            dp[1] = num[1];
            dp[2] = dp[1] + num[2];
            dp[3] = dp[1] + num[3];
            int index;
            int floor = 2;
            for(int i = 4; i < num.length; i = i + floor) {
                floor++;
                index = i;
                dp[i] = dp[i - floor + 1] + num[i];
                for(int j = 0; j < floor - 2; j++) {
                    dp[index+(j + 1)] = Math.max(dp[i - floor + (j + 1)] + num[index+(j + 1)], dp[i - floor + (j + 2)] + num[index+(j + 1)]);
                }
                dp[i + (floor - 1)] = dp[i - 1] + num[i + (floor - 1)];
            }
            int answer = 0;
            for(int i = num.length - floor; i < num.length; i++) {
                answer = Math.max(dp[i], answer);
            }
            return answer;
        }
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            int full_size = 0;
            for(int i = 1; i <= size; i++) {
                full_size += i;
            }
            int[] num = new int[full_size + 1];
            int cnt = 1;
            StringTokenizer st;
            for(int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < i + 1; j++) {
                    num[cnt++] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(String.valueOf(solution(num, size)));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
