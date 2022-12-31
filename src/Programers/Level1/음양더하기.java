package Programers.Level1;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] x = {4,7,12};
        boolean[] y = {true,false,true};
        System.out.println(new 음양더하기().solution(x, y));
    }
}
