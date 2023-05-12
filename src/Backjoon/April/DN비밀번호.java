package Backjoon.April;

import java.io.*;
import java.util.StringTokenizer;

public class DN비밀번호 {

    public static int[] checkArray;
    public static int[] key;
    public static int check;

    public static int solution(String DNA, int subDNASize) {
        int answer = 0;
        String temp;
        check = 0;
        temp = DNA.substring(0, subDNASize);

        for (int k : key) if (k == 0) check++;
        for(int i = 0; i < temp.length(); i++) {
            add(temp.charAt(i));
        }

        if(check == 4) answer++;

        int j = 0;
        for(int i = subDNASize; i < DNA.length(); i++) {
            j = i - subDNASize;
            add(DNA.charAt(i));
            remove(DNA.charAt(j));
            if(check == 4) answer++;

        }

        return answer;
    }

    public static void add(char c) {
        if(c == 'A') {
            checkArray[0]++;
            if(checkArray[0] == key[0]) check++;
        }else if(c == 'C') {
            checkArray[1]++;
            if(checkArray[1] == key[1]) check++;
        }else if(c == 'G') {
            checkArray[2]++;
            if(checkArray[2] == key[2]) check++;
        }else {
            checkArray[3]++;
            if(checkArray[3] == key[3]) check++;
        }
    }

    public static void remove(char c) {
        if(c == 'A') {
            if(checkArray[0] == key[0])
                check--;
            checkArray[0]--;
        }else if(c == 'C') {
            if(checkArray[1] == key[1])
                check--;
            checkArray[1]--;
        }else if(c == 'G') {
            if(checkArray[2] == key[2])
                check--;
            checkArray[2]--;
        }else {
            if(checkArray[3] == key[3])
                check--;
            checkArray[3]--;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        checkArray = new int[4];
        key = new int[4];
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int DNASize = Integer.parseInt(st.nextToken());
            int subDNASize = Integer.parseInt(st.nextToken());
            String DNA = br.readLine();
            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < key.length; i++)
                key[i] = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(solution(DNA, subDNASize)));
            bw.close();
        } catch (IOException e) {

        }

    }

}
