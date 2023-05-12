package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class 토너먼트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(jimin != hansoo) {
            jimin = jimin/2 + jimin%2;
            hansoo = hansoo/2 + hansoo%2;
            cnt++;
        }
        System.out.println(cnt);

    }


}
