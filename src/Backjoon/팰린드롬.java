package Backjoon;

import java.io.*;
import java.util.*;

public class 팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int[] room = new int[26];

        for(int i = 0; i < line.length(); i++) {
            room[line.charAt(i) - 65]++;
        }

        int cnt = 0;
        String mid = "";
        for(int i = 0; i < room.length; i++) {
            if(room[i] % 2 != 0) {
                cnt++;
                mid = String.valueOf((char)(i + 65));
            }
        }

        String answer = "";
        if(cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        }else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < room.length; i++) {
                for(int j = 0; j < room[i]/2; j++) {
                    sb.append(String.valueOf((char)(i + 65)));
                }
            }
            answer += sb.toString();
            if(cnt == 1) answer += mid;
            answer += sb.reverse().toString();
            System.out.println(answer);
        }


    }
}
