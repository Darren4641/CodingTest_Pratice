package Backjoon.April;

import java.io.*;
import java.util.Arrays;

public class NQueen {
    //9663
    public static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    public static int N;
    public static int[][] arr;
    public static boolean[][] visit;
    public static boolean[][] temp;
    public static int count;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        count = 0;
        dfs(N, 0);
        System.out.println(count);
    }

    public static void dfs(int N, int depth) throws IOException {
        if (N == depth) {
            count++;
            return;
        }
        int wx = 0;
        int wy = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    //퀀을 놔도 되는 자리
                    visit[i][j] = true;
                    queenWay(i, j, true);
                    temp = visit;
                    System.out.println(Arrays.deepToString(arr));
                    dfs(N, depth + 1);
                    System.out.println("--------------");
                    System.out.println("depth = " + depth);
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    visit = temp;
                }


            }
        }

    }

    public static void queenWay(int x, int y, boolean status) {
        int wx = 0;
        int wy = 0;
        for(int i = 0; i < dx.length; i++) {
            wx = x + dx[i];
            wy = y + dy[i];
            while(isWay(wx, wy)) {
                if(status) {
                    visit[wx][wy] = true;
                }else {
                    visit[wx][wy] = false;
                }

                wx += dx[i];
                wy += dy[i];
            }
        }
    }

    public static boolean isWay(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
