package Backjoon;

import java.io.*;
import java.util.*;

public class 미로탐색 {
    public static final int[] X_POSITION = { -1, 1, 0, 0};
    public static final int[] Y_POSITION = { 0, 0, -1, 1};
    static int[][] way;
    static boolean[][] visited;

    public static int solution(int[][] num, int N, int M) {
        visited = new boolean[N][M];
        way = num;
        BFS(num, 0, 0, N, M);
        return way[N - 1][M - 1];
    }

    public static void BFS(int[][] way, int x, int y, int N, int M) {
        Deque<int[]> deque = new ArrayDeque<>();
        int dx, dy;
        deque.addLast(new int[] { x, y });
        visited[x][y] = true;
        int[] now;
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            for(int i = 0; i < 4; i++) {
                dx = now[0] + X_POSITION[i];
                dy = now[1] + Y_POSITION[i];
                if(isWay(dx, dy, N, M)) {
                    if(way[dx][dy] != 0 && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        deque.addLast(new int[] { dx, dy });
                        way[dx][dy] = way[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    public static boolean isWay(int dx, int dy, int N, int M) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] num = new int[N][M];
            String temp;
            for(int i = 0; i < N; i++) {
                temp = br.readLine();
                for(int j = 0; j < M; j++) {
                    num[i][j] = temp.charAt(j) - '0';
                }
            }
            bw.write(String.valueOf(solution(num, N, M)));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
