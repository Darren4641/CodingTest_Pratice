package Backjoon;

import java.io.*;

public class 거북이 {
    public static final int TOP = 0;
    public static final int RIGHT = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] lines = new String[N];

        for(int i = 0; i < lines.length; i++) {
            lines[i] = br.readLine();
        }

        int x;
        int y;
        int maxX, maxY;
        int minX, minY;
        boolean isX;
        int status;
        char ch;
        String line;
        for(int k = 0; k < lines.length; k++) {
            line = lines[k];
            x = 0;
            y = 0;
            maxX = 0;
            maxY = 0;
            minX = 0;
            minY = 0;
            isX = false;
            status = TOP;
            for(int i = 0; i < line.length(); i++) {
                ch = line.charAt(i);

                if(ch == 'F') {
                    if(!isX) {
                        if(status == TOP)
                            y++;
                        else y--;
                    }
                    else {
                        if(status == RIGHT)
                            x++;
                        else x--;
                    }
                }else if(ch == 'L' || ch == 'R') {
                    isX = !isX;
                    if(ch == 'L') status -= 1;
                    if(ch == 'R') status += 1;
                    if(status > 3) status = 0;
                    if(status < 0) status = 3;
                }else if(ch == 'B') {
                    if(!isX) {
                        if(status == TOP)
                            y--;
                        else y++;
                    }
                    else {
                        if(status == RIGHT)
                            x--;
                        else x++;
                    }
                }
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
            bw.write(((maxX - minX) * (maxY - minY)) + "\n");
        }

        bw.close();
    }


}
