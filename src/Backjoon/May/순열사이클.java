package Backjoon.May;

import java.io.*;
import java.util.StringTokenizer;

public class 순열사이클 {
    public static int[] num;
    public static int N;
    public static int cnt;
    public static boolean visited[];

    public static void solution() throws IOException{
        cnt = 0;
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            DFS(i);
        }
        System.out.println(cnt);
    }

    private static void DFS(int index) {
        if(index - 1 >= 0) {
            if(!visited[num[index]]) {
                visited[index] = true;
                cnt++;
                DFS(num[index]);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        //순열의 크기
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
                num[j] = Integer.parseInt(st.nextToken());
            solution();
        }

    }

}
