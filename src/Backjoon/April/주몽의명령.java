package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

    public static int solution(int[] arr, int num) {
        Arrays.sort(arr);

        int answer = 0;
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum < num) {
                start++;
            }else if(sum > num) {
                end--;
            }else {
                answer++;
                start++;
                end--;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < size; i++) {

                arr[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(String.valueOf(solution(arr, num)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
