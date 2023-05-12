package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수구하기 {

    public static int solution(long[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            if(isGood(arr, i)) answer++;
        }
        return answer;
    }
    public static boolean isGood(long[] arr, int index) {
        int start = 0;
        int end = arr.length - 1;
        long sum = 0;
        while (true) {
            if(start == index) start++;
            if(end == index) end--;
            if(start >= end) return false;
            sum = arr[start] + arr[end];
            if (sum < arr[index]) start++;
            else if (sum > arr[index]) end--;
            else return true;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            long[] arr = new long[size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < size; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            bw.write(String.valueOf(solution(arr)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
