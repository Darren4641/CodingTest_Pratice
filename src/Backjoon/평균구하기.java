package Backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class 평균구하기 {

    public static double solution(int num, int[] grade) {
        double answer = 0;
        int max = 0;
        for(int i = 0; i < grade.length; i++) {
            if(max < grade[i])
                max = grade[i];
        }
        int sum = 0;

        for(double i : grade) {
            sum += Math.round(i/max*100)/100.0 * 100.0;
        }

        return sum / (double) num;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp, " ");
            int[] grade = new int[num];
            for(int i = 0; i < num; i++) {
                grade[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solution(num, grade));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
