package Backjoon.May;

import java.io.*;
import java.util.*;

public class dfsbfs {
    public static int N;
    public static int M;
    public static int V;
    public static LinkedList[] arr;
    public static boolean[] visited;
    public static Deque<Integer> deque;

    public static void init(StringTokenizer st, BufferedReader br) throws IOException {
        arr = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        deque = new ArrayDeque<Integer>();
        for(int i = 1; i< arr.length; i++)
            arr[i] = new LinkedList<Integer>();

        int left, right;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            arr[left].addLast(right);
            arr[right].addLast(left);
        }
        sort();

    }

    private static void sort() {
        for(int i = 1; i < arr.length; i++)
            Collections.sort(arr[i]);
    }

    private static void DFS(LinkedList<Integer> list, int value) {
        System.out.print(value + " ");
        visited[value] = true;

        for(int i = 0; i < list.size(); i++) {
            searchDfs(list, i);
        }
    }

    private static void searchDfs(LinkedList<Integer> list, int i) {
        String temp;
        temp = String.valueOf(list.get(i));
        if(!visited[Integer.parseInt(temp)]) {
            DFS(arr[Integer.parseInt(temp)], Integer.parseInt(temp));
        }
    }

    private static void BFS(int index) {
        visited = new boolean[N + 1];
        visited[index] = true;
        deque.addLast(index);
        int now;
        while(!deque.isEmpty()) {
            now = deque.removeFirst();
            System.out.print(now + " ");
            for(Object value : arr[now]) {
                if(!visited[Integer.parseInt(String.valueOf(value))]) {
                    visited[Integer.parseInt(String.valueOf(value))] = true;
                    deque.addLast(Integer.parseInt(String.valueOf(value)));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //시작 번호

        init(st, br);

        DFS(arr[V], V);
        System.out.println();
        BFS(V);

    }
}
