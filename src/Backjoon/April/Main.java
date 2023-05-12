package Backjoon.April;

import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public void run() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int data = 0;
        int out = 0;
        try {
            int num = Integer.parseInt(br.readLine());
            for(int i = 0; i < num; i++) {
                data = Integer.parseInt(br.readLine());
                if(data == 0)
                    if(pq.isEmpty())
                        wr.write("0\n");
                    else {
                        out = pq.poll();
                        if(map.get(out * -1) == null || map.get(out * -1) == 0) wr.write(out + "\n");
                        else {
                            if(map.get(out * -1) > 0) {
                                wr.write((out * -1) + "\n");
                                map.put((out * -1), map.get((out * -1)) - 1);
                            }
                        }
                    }
                else {
                    if(data < 0) {
                        if(map.get(data) == null)
                            map.put(data, 1);
                        else
                            map.put(data, map.get(data) + 1);
                    }
                    pq.add(Math.abs(data));
                }

            }
            wr.flush();
            wr.close();
        } catch (IOException e) { e.printStackTrace(); }

    }

    public static void main(String[] args) { new Main().run();}
}
