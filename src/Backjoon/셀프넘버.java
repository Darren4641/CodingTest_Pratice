package Backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 셀프넘버 {

    public static boolean[] solution() {
        boolean[] result = new boolean[10001];
        int k = 0;
        for(int i = 1; i <= 10000; i++) {
            k = d(i);
            if(k <= 10000)
                result[d(i)] = true;
        }
        return result;
    }

    public static int d(int N) {
        int sum = N;
        String num = String.valueOf(N);
        for(int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            boolean[] result = solution();

            for(int i = 1; i <= 10000; i++) {
                if(!result[i]) {
                    bw.write(i + "\n");
                }

            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
