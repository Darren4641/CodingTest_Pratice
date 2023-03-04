package Backjoon.BFS;

import java.io.*;
import java.util.*;

public class BFS1 {
    public static boolean[] visited;
    public static LinkedList<Integer>[] node;
    public static int[] num;
    public static int[] depth;

    public static void solution(int startEdge) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        visited = new boolean[node.length];
        num = new int[node.length];
        depth = new int[node.length];

        for(int i = 1; i < depth.length; i++) {
            depth[i] = -1;
        }

        BFS(startEdge);
        long sum = 0;
        for(int i = 1; i < node.length; i++) {
            sum += (long) num[i] * depth[i];

        }
        bw.write(sum + "");
        bw.close();
    }

    public static void BFS(int v) {
        int cnt = 1;
        int d = 1;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        visited[v] = true;
        deque.addLast(v);

        depth[v] = 0;
        int now;
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            num[now] = cnt;

            for(int n : node[now]) {
                if(!visited[n]) {
                    visited[n] = true;
                    deque.addLast(n);
                    depth[n] = depth[now] + 1;
                }
            }

            cnt++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = new LinkedList[Integer.parseInt(st.nextToken()) + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new LinkedList<Integer>();
        }

        int edgeCount = Integer.parseInt(st.nextToken());
        int startEdge = Integer.parseInt(st.nextToken());
        int n1, n2;
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            node[n1].add(n2);
            node[n2].add(n1);
        }

        for (int i = 1; i < node.length; i++) {
            Collections.sort(node[i]);
        }

        solution(startEdge);

    }

}
