package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드 {

    public static void solution(int[] array) throws IOException {
        int max;
        for(int i = 0; i < array.length; i++) {
            max = array[i];
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] > array[max]) {
                    max = array[i];
                }
            }

        }
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String num = br.readLine();
            int[] array = new int[num.length()];
            for(int i = 0; i < num.length(); i++) {
                array[i] = num.charAt(i) - '0';
            }

            solution(array);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
