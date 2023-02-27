package Backjoon;

import java.io.*;
import java.util.*;

public class 최솟값구하기 {

    static class Node {
        private int index;
        private long value;

        public Node(int index, long value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return index; }

        public long getValue() { return value; }
    }

    public static void solution(long[] num, int window) throws IOException {
        Deque<Node> deque = new ArrayDeque<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < num.length; i++) {
            while(!deque.isEmpty() && deque.getLast().getValue() > num[i])
                deque.removeLast();

            deque.addLast(new Node(i, num[i]));

            if(deque.getFirst().getIndex() <= i - window)
                deque.removeFirst();

            bw.write(deque.getFirst().getValue() + " ");
        }
        bw.close();
    }


    public static void main(String[] args) {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            int windowSize = Integer.parseInt(st.nextToken());
            long[] num = new long[size];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < size; i ++) {
                num[i] = Long.parseLong(st.nextToken());
            }
            solution(num, windowSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
