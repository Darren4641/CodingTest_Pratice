package Backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N과M {

    public static int[] arr;
    public static boolean[] visit;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        bw.close();
    }

    public static void dfs(int N, int M, int depth) throws IOException{

        if(M == depth) {
            for(int i = 0; i < arr.length; i++)
                bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = true;
                for(int j = i + 1; j < N; j++)
                    visit[j] = false;
            }

        }

    }



}
