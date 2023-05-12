package Backjoon.April.Soma;

import java.io.*;

public class 로마숫자만들기 {
    public static int[] roma = { 1, 5, 10, 50};
    public static boolean[] visit;
    public static int answer = 0;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //로마 숫자 세팅
        visit = new boolean[1001];

        N = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);
        bw.write(answer + "");
        bw.close();

    }

    public static void dfs(int depth, int start, int sum) {
        if(depth == N) {
            if(!visit[sum]) {
                visit[sum] = true;
                answer++;
            }
            return;
        }
        for(int i = start; i < roma.length; i++) {
            dfs(depth + 1, i, sum + roma[i]);
        }
    }

}
