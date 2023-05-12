package Backjoon.April;

import java.io.*;

public class 연속된자연수의합구하기 {

    public static int solution(int N) {
        int answer = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

        while(end != N) {
            if(sum == N) {
                answer++;
                end++;
                sum += end;
            }else if(sum < N) {
                end++;
                sum += end;
            }else {
                sum -= start;
                start++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solution(N)) + "\n");
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
