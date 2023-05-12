package Backjoon.April;

import java.io.*;

public class 버블정렬 {

    public static void solution(int[] num) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int temp;
        for(int i = 0; i < num.length - 1; i++) {
            for(int j = 0; j <num.length - 1 - i; j++) {
                if(num[j] > num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < num.length; i++) {
            bw.write(num[i] + "\n");
        }
        bw.close();
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int size = Integer.parseInt(br.readLine());
            int[] num = new int[size];
            for(int i = 0 ; i < size; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            solution(num);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
