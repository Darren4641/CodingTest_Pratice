package Backjoon.April;

import java.io.*;
import java.util.*;

public class 안전영역 {
    public static final int[] DX = {0, 0, -1, 1};
    public static final int[] DY = {-1, 1, 0, 0};
    static int[][] house;
    static int N;
    static boolean[][] visited;

    public static void solution() {
        List<Integer> list = new ArrayList<>();
        int[][] empty = new int[N][N];
        int cnt = 0;
        int rain = 0;
        while(!Arrays.deepEquals(house, empty)) {
            checkDead(rain);
            visited =  new boolean[N][N];
            cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && house[i][j] != 0) {
                        cnt++;
                        DFS(i, j);
                    }


                }
            }
            list.add(cnt);
            rain++;
        }
        if(list.isEmpty()) {
            System.out.println(0);
            return;
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(0));

    }

    public static void checkDead(int rain) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(house[i][j] <= rain) {
                    house[i][j] = 0;
                }
            }
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        int wx, wy;
        for(int i = 0; i < 4; i++) {
            wx = x + DX[i];
            wy = y + DY[i];
            if(isWay(wx, wy) && !visited[wx][wy] && house[wx][wy] != 0) {
                DFS(wx, wy);
            }
        }

    }

    public static boolean isWay(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            N = Integer.parseInt(br.readLine());
            house = new int[N][N];
            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    house[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
