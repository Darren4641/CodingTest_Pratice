package Backjoon.April;

import java.io.*;

public class 숫자더하기 {

    public static int solution(int num) {
        int[] result = new int[num];

        if(result.length == 1) return 1;
        else if(result.length == 2) return 2;
        else if(result.length == 3) return 4;
        else {
            result[0] = 1;
            result[1] = 2;
            result[2] = 4;

            for(int i = 3; i < num; i++) {
                result[i] = result[i-3] + result[i-2] + result[i-1];
            }
        }


        return result[num - 1];
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num = Integer.parseInt(br.readLine());
            for(int i = 0; i < num; i++) {
                bw.write(String.valueOf(solution(Integer.parseInt(br.readLine()))) + "\n");
            }
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
