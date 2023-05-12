package Backjoon.April;

import java.io.*;

public class 이상한소수 {
    public static final int[] COMPARE = {1, 3, 5, 7, 9};


    public static void solution(int size) {
        DFS(2, size, 1);
        DFS(3, size, 1);
        DFS(5, size, 1);
        DFS(7, size, 1);
    }

    public static void DFS(int num, int size, int k) {
        int temp;
        if(k == size) {
            System.out.println(num);
            return;
        }
        for (int j : COMPARE) {
            temp = (num * 10) + j;
            if (isPrime(temp)) DFS(temp, size, k + 1);
        }
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i <= (num / 2); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int size = Integer.parseInt(br.readLine());

            solution(size);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
