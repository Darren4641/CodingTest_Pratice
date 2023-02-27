package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2 {

    public static void solution(int card) {
        Deque<Integer> deque = new ArrayDeque<>();
        int temp;
        for(int i = 1; i <= card; i++) {
            deque.addLast(i);
        }

        while(deque.size() != 1) {
            deque.removeFirst();
            temp = deque.getFirst();
            deque.removeFirst();
            deque.addLast(temp);
        }
        System.out.println(deque.getFirst());
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int card = Integer.parseInt(br.readLine());

            solution(card);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
