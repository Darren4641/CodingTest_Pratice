package Programers.Level1;

public class 없는숫자더하기 {

    public static int solution(int[] numbers) {
        int answer = 0;
        int compare = 45;
        for(int number : numbers) {
            answer += number;
        }
        return compare - answer;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,6,7,8,0};
        System.out.println(solution(test));
    }
}
