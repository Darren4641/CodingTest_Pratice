package Backjoon.April;

import java.io.*;
import java.util.*;

public class 친구관계파악 {
    static List<Integer>[] list;
    static boolean[] visited;

    public static int solution(int[] num, int nodeSize) {
        list = new ArrayList[nodeSize];
        visited = new boolean[nodeSize];
        for(int i = 0; i < nodeSize; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < num.length; i = i + 2) {
            list[num[i]].add(num[i+1]);
            list[num[i+1]].add(num[i]);
        }

        for(int i = 0; i < nodeSize; i++) {
            if(DFS(list[i], i, 1)) return 1;
        }
        return 0;
    }

    public static boolean DFS(List<Integer> temp, int index, int depth) {
        if(depth == 5) {
            return true;
        }
        visited[index] = true;
        for(int i = 0; i < temp.size(); i++) {
            if(!visited[temp.get(i)]) {
                if(DFS(list[temp.get(i)], temp.get(i), depth + 1)) {
                    return true;
                }
            }
        }
        visited[index] = false;
        return false;
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int[] num = new int[edgeSize * 2];
            for(int i = 0; i < num.length; i = i + 2) {
                st = new StringTokenizer(br.readLine(), " ");
                num[i] = Integer.parseInt(st.nextToken());
                num[i + 1] = Integer.parseInt(st.nextToken());
            }

            bw.write(String.valueOf(solution(num, nodeSize)));
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
