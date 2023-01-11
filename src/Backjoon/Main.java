package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coin = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin = Integer.parseInt(st.nextToken());
            if(coin < K)
                pq.add(coin);
        }

        int tmp = K;
        int coinKind = 0;
        int answer = 0;
        while(tmp != 0) {
            coinKind = pq.poll();
            if(coinKind < tmp) {
                System.out.println("@@ : " + coinKind);
                answer += tmp/coinKind;
                tmp -= coinKind * (tmp/coinKind);
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
