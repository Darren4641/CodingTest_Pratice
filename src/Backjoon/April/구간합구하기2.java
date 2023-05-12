package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기2 {

    public static int solution(int[][] sumArray, int x1, int y1, int x2, int y2) {
        return sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][y1 - 1] + sumArray[x1 - 1][y1 - 1];
    }

    public static int[][] sumArray(int[][] num, int size) {
        int[][] temp = new int[size + 1][size + 1];
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j - 1] + num[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arraySize = Integer.parseInt(st.nextToken());
            int question = Integer.parseInt(st.nextToken());
            int[][] num = new int[arraySize + 1][arraySize + 1];

            //2차원 배열 생성
            for(int i = 1; i <= arraySize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= arraySize; j++) {
                    num[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] sumArray = sumArray(num, arraySize);

            //답안
            for(int i = 0; i < question; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bw.write(String.valueOf(solution(sumArray ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) + "\n");
            }
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
