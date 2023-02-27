package Backjoon;

import java.io.*;
import java.util.*;

public class 에디터 {
    static List<String> list;

    public static void solution(String init, String[] cmd) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cursor = list.size();

        for(String c : cmd) {
            if(c.equals("L")) {
                if(cursor != 0)
                    cursor--;
            }else if(c.equals("D")) {
                if(cursor != list.size())
                    cursor++;
            }else if(c.equals("B")) {
                if(cursor != 0) {
                    list.remove(cursor - 1);
                    cursor--;
                }
            }else {
                list.add(cursor, String.valueOf(c.charAt(2)));
                cursor++;
            }

        }

        for(String l : list) {
            bw.write(l);
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String init = br.readLine();

            list = new ArrayList<String>();
            for(int i = 0; i < init.length(); i++) {
                list.add(String.valueOf(init.charAt(i)));
            }
            int cmdSize = Integer.parseInt(br.readLine());
            String[] cmd = new String[cmdSize];

            for(int i = 0; i < cmd.length; i++) {
                cmd[i] = br.readLine();
            }

            solution(init, cmd);

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
