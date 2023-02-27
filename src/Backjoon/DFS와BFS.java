package Backjoon;

import java.io.*;
import java.util.*;

public class DFS와BFS {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void solution(int nodeSize, int[] num, int start) {

        insertNode(nodeSize + 1, num);
        sortNode(nodeSize + 1);
        DFS(list[start], start);
        System.out.println();
        Arrays.fill(visited, false);
        BFS(start);


    }

    public static void DFS(List<Integer> element, int index) {
        System.out.print(index + " ");
        visited[index] = true;

        for(int value : element) {
            if(!visited[value]) {
                DFS(list[value], value);
            }
        }
    }

    public static void BFS(int index) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited[index] = true;
        deque.addLast(index);
        int now;
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            System.out.print(now + " ");
            for(int value : list[now]) {
                if(!visited[value]) {
                    visited[value] = true;
                    deque.addLast(value);
                }
            }
        }

    }

    public static void insertNode(int nodeSize, int[] num) {
        list = new ArrayList[nodeSize];
        visited = new boolean[nodeSize];

        for(int i = 1; i < nodeSize; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < num.length; i = i + 2) {
            list[num[i]].add(num[i+1]);
            list[num[i+1]].add(num[i]);
        }
    }

    public static void sortNode(int nodeSize) {
        for(int i = 1; i < nodeSize; i++) {
            Collections.sort(list[i]);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int start =  Integer.parseInt(st.nextToken());
            int[] num = new int[edgeSize * 2];
            for(int i = 0; i < edgeSize * 2; i = i +2) {
                st = new StringTokenizer(br.readLine(), " ");
                num[i] = Integer.parseInt(st.nextToken());
                num[i + 1] = Integer.parseInt(st.nextToken());
            }

            solution(nodeSize, num, start);


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
