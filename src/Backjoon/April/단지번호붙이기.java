package Backjoon.April;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {
    public static final int[] dx = {0,0,-1,1};
    public static final int[] dy = {-1,1,0,0};
    static int[][] house;
    static boolean[][] visited;
    static int N;
    static int count;
    public static void solution() {
        List<Integer> countList = new ArrayList<>();
        visited = new boolean[N][N];
        int dong = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && house[i][j] == 1) {
                    count = 0;
                    DFS(i, j, dong);
                    dong++;
                    countList.add(count);
                }
            }
        }

        Collections.sort(countList);
        System.out.println(dong - 1);
        for(int i : countList)
            System.out.println(i);

    }

    public static void DFS(int x, int y, int dong) {
        count++;
        visited[x][y] = true;

        int wx, wy;
        for(int i = 0; i < 4; i++) {
            wx = x + dx[i];
            wy = y + dy[i];
            if(isWay(wx, wy) && !visited[wx][wy] && house[wx][wy] == 1) {
                house[wx][wy] = dong;
                DFS(wx, wy, dong);
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
            String temp;
            for(int i = 0; i < N; i++) {
                temp = br.readLine();
                for(int j = 0; j < N; j++) {
                    house[i][j] = temp.charAt(j) - '0';
                }
            }
            solution();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
