package Programers.Level1;

public class 나머지1찾기 {
    public static int solution(int n) {
        int answer = n - 1;

        for(int i = 2; i <= answer; i++) {
            if(answer % i == 0)
                return i;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(324));
    }
}

/*

자연수 n이 매개변수로 주어집니다.
n을 x로 나눈 나머지가 1이 되도록 하는
가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
답이 항상 존재함은 증명될 수 있습니다.

n	result
10	3
12	11
 */
