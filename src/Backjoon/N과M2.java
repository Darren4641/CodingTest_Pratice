package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
    public static int[] arry;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arry = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth) {

        if(M == depth) {
            for(int i = 0; i < arry.length; i++) {
                System.out.print(arry[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arry[depth] = i + 1;
                dfs(N, M, depth + 1);
                for(int j = i + 1; j < N; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}
