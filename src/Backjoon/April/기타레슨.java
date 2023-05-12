package Backjoon.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {

    public static void solution(int[] media, int lessonCnt, int blueLayCnt) {
        int start = 0;
        int end = 0;
        for(int i : media) {
            start = Math.max(start, i);
            end += i;
        }

        int cnt;
        int sum = 0;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            cnt = 0;
            sum = 0;
            for(int i : media) {
                if(sum + i > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += i;
            }
            if(sum != 0) cnt++;

            if(cnt > blueLayCnt) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(start);

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int lessonCnt = Integer.parseInt(st.nextToken());
            int blueLayCnt = Integer.parseInt(st.nextToken());
            int[] media = new int[lessonCnt];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < lessonCnt; i++) {
                media[i] = Integer.parseInt(st.nextToken());
            }
            solution(media, lessonCnt, blueLayCnt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
