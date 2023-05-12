package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 나머지합구하기 {

    public static long solution(long[] sumArray, int M) {
        long answer = 0;
        long[] result = new long[M];
        int div = 0;
        for(int i = 1; i < sumArray.length; i++) {
            div = (int) (sumArray[i] % M);
            if(div == 0)
                answer++;
            result[div]++;
        }

        for(int i = 0; i < M; i++) {
            if(result[i] > 1)
                answer += (result[i] * (result[i] - 1) / 2);
        }

        return answer;
    }

    public static long[] getSumArray(long[] num) {
        long[] temp = new long[num.length];
        for(int i = 1; i < num.length; i++) {
            temp[i] = temp[i - 1] + num[i];
        }
        return temp;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arraySize = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long[] num = new long[arraySize + 1];
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            for(int i = 1; i < num.length; i++) {
                num[i] = Integer.parseInt(st2.nextToken());
            }

            long[] sumArray = getSumArray(num);
            bw.write(String.valueOf(solution(sumArray, M)) + "\n");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
