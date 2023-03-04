package Backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS1 {

    static LinkedList<Integer>[] node;
    static boolean[] visited;
    static List<Integer> num;
    public static void solution(int startEdge) {
        visited = new boolean[node.length];
        num = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        int[] result = new int[node.length];
        DFS(startEdge);

        int priority = 1;
        for(int n : num) {
            result[n] = priority;
            priority++;
        }

        for(int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }



    }

    public static void DFS(int v) {
        visited[v] = true;
        num.add(v);
        for(int n : node[v]) {
            if(!visited[n]) {
                DFS(n);

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
                Collections.sort(node[i]);
            }

            solution(startEdge);

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}
