package Backjoon.April;

import java.io.*;
import java.util.*;

public class 에디터 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String init = br.readLine();

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            for(int i = 0; i < init.length(); i++) {
                leftStack.push(init.charAt(i));
            }
            int cmdSize = Integer.parseInt(br.readLine());


            String command;
            for(int i = 0; i < cmdSize; i++) {
                command = br.readLine();

                switch (command.charAt(0)) {
                    case 'L':
                       if(leftStack.empty()) break;
                       rightStack.push(leftStack.pop());
                        break;
                    case 'D':
                       if(rightStack.empty()) break;
                       leftStack.push(rightStack.pop());
                        break;
                    case 'B':
                        if(leftStack.empty()) break;
                        leftStack.pop();
                        break;
                    case 'P':
                        leftStack.push(command.charAt(2));
                        break;
                }

            }

            while(!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while(!rightStack.empty()) {
                sb.append(rightStack.pop());
            }
            bw.write(sb.toString());
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
