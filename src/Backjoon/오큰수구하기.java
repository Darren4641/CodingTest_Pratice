package Backjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수구하기 {

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

    public static long[] solution(long[] num) throws IOException{
        long[] answer = new long[num.length];
        Stack<Node> stack = new Stack<Node>();

        stack.push(new Node(0, num[0]));
        for(int i = 1; i < num.length; i++) {
            if(stack.peek().getValue() < num[i]) {
                while(!stack.empty() && stack.peek().getValue() < num[i]) {
                    answer[stack.pop().getIndex()] = num[i];
                }
                stack.push(new Node(i, num[i]));
            }else {
                stack.push(new Node(i, num[i]));
            }
        }
        Node node;
        while(!stack.empty()) {
            node = stack.pop();
            answer[node.getIndex()] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int size = Integer.parseInt(br.readLine());
            long[] num = new long[size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < size; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            long[] result = solution(num);
            for(long r : result) {
                bw.write(r + " ");
            }
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
