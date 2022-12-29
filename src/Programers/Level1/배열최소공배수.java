package Programers.Level1;

public class 배열최소공배수 {

    public int solution(int[] arr) {
        int answer = 1;
        int gcdValue;
        for(int i : arr)
            answer = lcd(i, answer);

        return answer;
    }

    private int lcd(int a, int b) { return (a * b) / gcd(a, b); }

    private int gcd(int a, int b) {
        int tmp;
        if(a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        int[] case1 = {2,6,8,14};
        int[] case2 = {1, 2, 3};
        System.out.println(new 배열최소공배수().solution(case1));
        System.out.println("--------------------------------------");
        System.out.println(new 배열최소공배수().solution(case2));

    }
}





/*
문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.
입출력 예
arr	result
[2,6,8,14]	168
[1,2,3]	6

 */