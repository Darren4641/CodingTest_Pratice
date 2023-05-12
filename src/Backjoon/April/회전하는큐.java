package Backjoon.April;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
    public static LinkedList<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] target = new int[M];
        //초기화
        for(int i = 1; i <= N; i++)
            deque.addLast(i);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < target.length; i++)
            target[i] = Integer.parseInt(st.nextToken());

        int mid;
        int temp;
        for(int i = 0; i < target.length; i++) {
            while(!isTarget(target[i])) {
                if(isLeft(target[i])) {
                    left();
                    answer++;
                }else {
                    right();
                    answer++;
                }
            }
            deque.removeFirst();
        }
        bw.write(answer + "");
        bw.close();
    }

    public static boolean isTarget(int num) {
        return (deque.getFirst() == num);
    }

    public static void left() {
        int temp = deque.removeFirst();
        deque.addLast(temp);
    }

    public static void right() {
        int temp = deque.removeLast();
        deque.addFirst(temp);
    }

    public static boolean isLeft(int num) {
        for(int i = 0; i <= deque.size()/2; i++)
            if(deque.indexOf(num) == i) return true;

        return false;
    }
}
