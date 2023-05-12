package Backjoon.April;

import java.io.*;
import java.util.PriorityQueue;

public class 절댓값힙 {

    public static void solution(int[] num) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });

        for(int i = 0; i < num.length; i++) {
            if(num[i] == 0) {
                if (pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(pq.poll() + "\n");

            }else {
                pq.add(num[i]);
            }
        }
        bw.close();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int size = Integer.parseInt(br.readLine());
            int[] num = new int[size];
            for(int i = 0; i < size; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            solution(num);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
