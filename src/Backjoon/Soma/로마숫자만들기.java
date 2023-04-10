package Backjoon.Soma;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 로마숫자만들기 {

    static int[] num;
    static boolean[] visited;
    static int count;
    static Map<Integer, Integer> map;
    public static void solution(int[] num) {
        map = new HashMap<>();
        visited = new boolean[num.length];
        for(int i = 0; i < num.length; i++) {
            DFS(i, 0, num[i]);
        }

    }

    public static void DFS(int n, int d, int s) {
        if(d == count) {
            System.out.println(s);
        }

        visited[n] = true;
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                DFS(i, d + 1, s + num[i]);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new HashMap<Integer, String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = new int[] { 1, 5, 10, 50};
        count = Integer.parseInt(br.readLine());

        solution(num);
    }

}
