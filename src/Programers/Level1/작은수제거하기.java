package Programers.Level1;

import java.util.Arrays;

public class 작은수제거하기 {
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int minIndex = findMinIndex(arr);
        if(arr.length <= 1) {
            int[] error = {-1};
            return error;
        }
        int k = 0;
        for(int i = 0; i < answer.length; i++) {
            if(i == minIndex) {
                k++;
            }
            answer[i] = arr[k];
            k++;
        }
        return answer;
    }

    private static int findMinIndex(int[] arr) {
        int minNum = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(minNum > arr[i])
                minNum = arr[i];
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == minNum)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test = {4, 2, 1, 3};
        int[] test2 = {10};
        int[] result = solution(test);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
