package Backjoon.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최공최공 {


    public static void solution(int a, int b) {
        int X = eucd(Math.max(a, b), Math.min(a, b));
        int Y = 0;


        Y = X * (a / X) * (b / X);

        System.out.println(X);
        System.out.println(Y);

    }

    public static int eucd(int a, int b) {
        int temp = a % b;
        if(temp == 0)
            return b;
        else
            return eucd(b, temp);

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            solution(a, b);


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
