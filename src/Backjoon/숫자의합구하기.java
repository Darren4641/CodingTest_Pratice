package Backjoon;

import java.io.*;

public class 숫자의합구하기 {



    public static int solution(int num_count, int[] num) {
        int answer = 0;
        for(int i = 0; i < num_count; i++) {
            answer += num[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num_count = Integer.parseInt(br.readLine());
            int[] num = new int[num_count];
            String temp = String.valueOf(br.readLine());
            for(int i = 0; i < num.length; i++) {
                num[i] = temp.charAt(i) - '0';
            }
            System.out.println(solution(num_count, num));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
