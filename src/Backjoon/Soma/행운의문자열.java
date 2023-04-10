package Backjoon.Soma;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 행운의문자열 {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String temp;

        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            temp = String.valueOf(s.charAt(i));
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }else map.put(temp, 1);
        }
        for (String value : map.keySet()) {
            System.out.println(map.get(value));
        }
        if(answer == 0) answer = 1;

        bw.write(answer + "");
        bw.close();

    }

}
