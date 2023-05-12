package Backjoon.May;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(num);
        //시작 지점
        int start = 0;
        //끝 지점
        int end = n - 1;
        int cnt = 0;
        int sum = 0;
        while(start < end) {
            sum = num[start] + num[end];
            if(sum == x) {
                cnt++;
            }
            if(sum < x) {
                start++;
            }else {
                end--;
            }
        }
        System.out.println(cnt);
//1 2 3 5 7 9 10 11 12

    }
}
