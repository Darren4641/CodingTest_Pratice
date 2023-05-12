package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기 {

    public static int solution(int[] sumArray, int start, int end) {

        return sumArray[end] - sumArray[start - 1];
    }

    public static int[] sumArray(int[] num) {
        int[] temp = new int[num.length + 1];
        temp[0] = 0;
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
            sum += num[i];
            temp[i + 1] = sum;
        }

        return temp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int arraySize = Integer.parseInt(st1.nextToken());
            int inputSize = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int[] num = new int[arraySize];
            for(int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st2.nextToken());
            }
            int[] sumArray = sumArray(num);
            StringTokenizer st = null;
            for(int i = 0; i < inputSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                System.out.println(solution(sumArray, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
