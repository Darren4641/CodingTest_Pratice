package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] way = new long[N - 1];
        long[] oil = new long[N];
        for(int i = 0 ; i < N - 1; i++) {
            way[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min = oil[0];
        for(int i = 0; i < way.length; i++) {
            if(min > oil[i])
                min = oil[i];
            sum += min * way[i];
        }
        bw.write(sum + "");
        bw.close();
    }

}
