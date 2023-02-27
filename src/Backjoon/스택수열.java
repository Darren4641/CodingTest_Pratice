package Backjoon;

import java.io.*;
import java.util.Stack;

public class 스택수열 {

    public static void solution(int[] num) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int k = 1;

        for(int i = 1; i < num.length; i++) {
            if(k <= num[i]) {
                while(k <= num[i]) {
                    stack.push(k);
                    k++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else {
                if(stack.peek() > num[i]) {
                    sb.append("NO");
                    bw.write("NO");
                    flag = false;
                    break;
                }
                stack.pop();
                sb.append("-\n");
            }

        }
        if(flag) bw.write(sb.toString());
        bw.close();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            //8
            int size = Integer.parseInt(br.readLine());
            int[] num = new int[size + 1];

            for(int i = 1; i <= size; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }

            solution(num);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
