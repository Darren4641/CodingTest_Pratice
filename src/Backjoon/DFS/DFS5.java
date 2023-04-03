package Backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS5 {
    static LinkedList<Integer>[] node;
    static boolean[] visited;
    static int[] result1;
    static int[] result2;
    static int cnt;

    public static void solution(int startEdge) {
        long answer = 0;
        visited = new boolean[node.length];
        result1 = new int[node.length];
        result2 = new int[node.length];
        cnt = 1;
        DFS(startEdge, 0);

        for(int i = 1; i < visited.length; i++) {
            answer += (long) result1[i] * result2[i];

        }

        System.out.println(answer);
    }

    public static void DFS(int v, int index) {
        visited[v] = true;
        result1[v] = index;
        result2[v] = cnt++;
        for(int n : node[v]) {
            if(!visited[n]) {
                DFS(n, index + 1);
            }
        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            node = new LinkedList[Integer.parseInt(st.nextToken()) + 1];

            for(int i = 1; i < node.length; i++) {
                node[i] = new LinkedList<Integer>();
            }

            int edgeCount = Integer.parseInt(st.nextToken());
            int startEdge = Integer.parseInt(st.nextToken());
            int n1, n2;
            for(int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                n1 = Integer.parseInt(st.nextToken());
                n2 = Integer.parseInt(st.nextToken());
                node[n1].add(n2);
                node[n2].add(n1);
            }

            for(int i = 1; i < node.length; i++) {
                Collections.sort(node[i], Collections.reverseOrder());
            }

            solution(startEdge);

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
