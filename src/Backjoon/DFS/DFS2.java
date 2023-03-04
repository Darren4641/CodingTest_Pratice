package Backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS2 {
    static boolean[] visited;
    static LinkedList<Integer>[] node;
    static List<Integer> resultList;

    public static void solution(int start) {
        visited = new boolean[node.length];
        resultList = new ArrayList<>();
        int[] result = new int[node.length];
        DFS(start);

        int pr = 1;
        for(int r : resultList) {
            result[r] = pr;
            pr++;
        }

        for(int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void DFS(int v) {
        visited[v] = true;
        resultList.add(v);

        for(int i : node[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = new LinkedList[Integer.parseInt(st.nextToken()) + 1];

        for(int i = 1; i <node.length; i++) {
            node[i] = new LinkedList<Integer>();
        }
        int edgeSize = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int v1, v2;
        for(int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            node[v1].add(v2);
            node[v2].add(v1);
        }
        for(int i = 1; i < node.length; i++) {
            Collections.sort(node[i], Collections.reverseOrder());
        }
        solution(start);



    }

}
