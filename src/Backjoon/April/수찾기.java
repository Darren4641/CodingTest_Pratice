package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {

    public static void solution(int[] num, int[] find) {
        int[] result = new int[find.length];
        Arrays.sort(num);
        //1 2 3 4 5

        int fIndex = 0;
        int start;
        int end;
        int mid;
        boolean status;

        for(int findValue : find) {
            start = 0;
            end = num.length -1;
            status = false;
            while(start <= end) {
                mid = (start + end) / 2;
                if(num[mid] < findValue) {
                    start = mid + 1;
                }else if(num[mid] > findValue) {
                    end = mid - 1;
                }else {
                    status = true;
                    break;
                }
            }
            if(status) {
                result[fIndex] = 1;
            }else {
                result[fIndex] = 0;
            }
            fIndex++;

        }

        for(int i = 0; i < find.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            int F = Integer.parseInt(br.readLine());
            int[] find = new int[F];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < F; i++) {
                find[i] = Integer.parseInt(st.nextToken());
            }
            solution(num, find);

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
