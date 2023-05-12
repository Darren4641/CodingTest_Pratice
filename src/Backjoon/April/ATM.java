package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    public static int solution(int[] num) throws IOException {
        Arrays.sort(num);
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < num.length; i++) {
            sum = (sum + num[i]);
            answer += sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] num = new int[size];
            for(int i = 0; i < size; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(solution(num) + "");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
