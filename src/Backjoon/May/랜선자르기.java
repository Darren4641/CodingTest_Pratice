package Backjoon.May;

import java.io.*;
import java.util.StringTokenizer;

public class 랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long min = 0;
        long max = 0;

        for(int i = 0; i < lans.length; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lans[i]);
        }
        max++;
        long mid;
        long count;
        while(min < max) {
            mid = (min + max) / 2;
            count = 0;
            for(int i = 0; i < lans.length; i++) {
                count += (lans[i] / mid);
            }

            if(count < N) max = mid;
            else min = mid + 1;
        }
        bw.write(min - 1 + "");
        bw.close();

    }
}
