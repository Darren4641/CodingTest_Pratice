package Backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class k번째수 {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] num = new int[Integer.parseInt(st.nextToken())];
            int find = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            bw.write(num[find - 1] + "");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
