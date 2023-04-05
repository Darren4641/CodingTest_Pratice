package Programers.Level2;

public class 조이스틱 {

    public static final int FRONT = 65;
    public static final int BACK = 91;

    public int solution(String name) {
        int answer = 0;
        int cnt = 0;
        int A_cnt = 0;
        int cursor = -1;

        for (int i = 0; i < (name.length() / 2) + 1; i++)
            if (name.charAt(i) == 'A') A_cnt++;


        for (int i = 0; i < name.length(); i++) {
            cnt = name.charAt(i);
            System.out.println(name.charAt(i) + " : " + Math.min((cnt - FRONT), (BACK - cnt)));
            answer += Math.min((cnt - FRONT), (BACK - cnt));
            //if (A_cnt >= name.length() /)
            //    cursor++;
        }


        return answer + cursor;
    }


}
