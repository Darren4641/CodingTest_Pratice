package Backjoon.April;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 버블소트 {

    static class Node {
        private int index;
        private long value;

        public Node(int index, long value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return this.index; }
        public long getValue() { return this.value; }
    }

    public static int solution(long[] num) {
        Map<Long, Node> before = new HashMap<>();
        Map<Long, Node> after = new HashMap<>();

        for(int i = 0; i < num.length; i++)
            before.put(num[i], new Node(i, num[i]));

        Arrays.sort(num);

        for(int i = 0; i < num.length; i++)
            after.put(num[i], new Node(i, num[i]));

        int max = 0;
        int temp;
        for(int i = 0; i < num.length; i++) {
            temp = before.get(num[i]).getIndex() - after.get(num[i]).getIndex();
            max = Math.max(max, temp);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            long[] num = new long[size];
            for(int i = 0; i < size; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            bw.write(solution(num) + "\n");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
