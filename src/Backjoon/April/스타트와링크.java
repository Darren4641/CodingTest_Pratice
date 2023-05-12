package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타트와링크 {
    public static int[][] S;
    public static boolean[] visited;
    public static int N;
    public static int min = 99999;

    public static void solution(int N) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        visited = new boolean[N];
        BT(0, 0);
        bw.write(min + "");
        bw.close();
    }

    public static void BT(int index, int height) {
        if(height == N / 2) {
            diff();
            return;

        }

        for(int i = index; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BT(i + 1, height + 1);
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    start += S[i][j];
                    start += S[j][i];
                }

                else if(!visited[i] && !visited[j]) {
                    link += S[i][j];
                    link += S[j][i];
                }

            }
        }
        min = Math.min(min, Math.abs(start - link));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(N);
        System.out.println(Arrays.deepToString(S));
    }
}
