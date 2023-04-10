package Backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N과M {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth) {

        if(M == depth) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }



}
