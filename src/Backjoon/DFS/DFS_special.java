package Backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_special {
    static boolean[] visited;
    static LinkedList<Integer>[] node;
    static int index;
    static int[] num;
    static int[] seq;
    //static List<Integer> l;
    static boolean status;
    public static void solution(int[] result) {
        visited = new boolean[node.length];
        seq = new int[node.length];
        num = new int[node.length];
        index = 2;

        for(int i = 1; i < result.length; i++) {
            seq[result[i]] = i;
        }
        for(int i = 1; i < node.length; i++) {
            DFS(i, seq[index]);
        }

        for(int i = 1; i < node.length; i++) {
            System.out.println(seq[i]);
        }
        if(status)
            System.out.println(1);
        else
            System.out.println(0);

    }

    public static void DFS(int v, int a) {
        status = false;
        if(visited[v]) {
            return;
        }
        System.out.println("v = " + v);
        visited[v] = true;
        for(int n : node[v]) {
            if(!visited[n] && n == a) {
                DFS(n, seq[index+1]);
                status = true;
            }else
                status = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeSize = Integer.parseInt(br.readLine());

        StringTokenizer st;
        node = new LinkedList[nodeSize + 1];
        for(int i = 1; i < node.length; i++) {
            node[i] = new LinkedList<>();
        }
        int v1, v2;
        for(int i = 0; i < nodeSize - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            node[v1].add(v2);
            node[v2].add(v1);
        }

        int[] result = new int[nodeSize + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        solution(result);
    }
}
