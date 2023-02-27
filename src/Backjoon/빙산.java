package Backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 빙산 {
    public static final int[] DX = {0, 0, -1, 1};
    public static final int[] DY = {-1, 1, 0, 0};
    static int[][] snow;
    static boolean[][] visited;
    static int N, M;
    static int count;
    static int year;

    public static void solution() {
        List<Integer> list = new ArrayList<>();
        int[][] empty = new int[N][M];
        boolean isMelt = false;

        year = 0;
        while(!Arrays.deepEquals(empty, snow)) {
            afterOneYear();
            if(count >= 2) {
                isMelt = true;
                break;
            }
        }

        if(isMelt) System.out.println(year - 1);
        else System.out.println(0);
    }

    public static void afterOneYear() {
        year++;
        visited = new boolean[N][M];
        count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && snow[i][j] != 0) {
                    count++;
                    DFS(i, j);
                }
            }
        }
    }

    public static int getZeroCnt(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            if(isWay(x+DX[i], y+DY[i]) && snow[x+DX[i]][y+DY[i]] == 0) cnt = cnt + 1;
        }
        return cnt;
    }

    public static void DFS(int x, int y) {
        int zero = getZeroCnt(x, y);
        visited[x][y] = true;

        int wx, wy;
        for(int i = 0; i < 4; i++) {
            wx = x + DX[i];
            wy = y + DY[i];
            if(isWay(wx, wy) && !visited[wx][wy] && snow[wx][wy] != 0) {
                DFS(wx, wy);
            }
        }
        snow[x][y] = snow[x][y] - zero;
        if(snow[x][y] < 0) snow[x][y] = 0;

    }

    public static boolean isWay(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snow = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    snow[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
