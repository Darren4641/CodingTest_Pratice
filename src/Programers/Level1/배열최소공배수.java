package Programers.Level1;

import java.util.*;

public class 배열최소공배수 {
    public static final int[] sosoo = { 2,3,5,7 };
    public int solution(int[] arr) {
        int answer = 1;
        int cnt;
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> result = new HashMap<String, Integer>();
        initMap(result);
        initMap(map);
        for(int num : arr) {
            map = getPrimeNumber(num, num, map);
            cnt = 0;

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(result.get(entry.getKey()) == null)
                    result.put(entry.getKey(), entry.getValue());
                else {
                    if(result.get(entry.getKey()) < entry.getValue())
                        result.put(entry.getKey(), entry.getValue());
                    if(entry.getValue() == 0)
                        cnt++;
                }

            }
            if(cnt == 4)
                result.put(Integer.toString(num), 1);

            initMap(map);
        }
        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                answer *= Integer.parseInt(entry.getKey());

            }

        }

        return answer;
    }

    private Map<String, Integer> getPrimeNumber(int num, int origin, Map<String, Integer> map) {
        if(num == 2 || num == 3 || num == 5 || num ==7 ) {
            map.put(Integer.toString(num),
                    map.get(Integer.toString(num)) + 1);
            return map;
        }else {
            for (int i = 2; i <= origin/2; i++) {
                if (num % i == 0) {
                    if(map.get(Integer.toString(i)) == null)
                        map.put(Integer.toString(i), 1);
                    else {
                        map.put(Integer.toString(i),
                                map.get(Integer.toString(i)) + 1);
                    }

                    return getPrimeNumber(num / i, num, map);
                }

            }

        }


        return map;
    }

    private Map<String, Integer> initMap(Map<String, Integer> map) {
        map.clear();
        map.put("2", 0); map.put("3", 0); map.put("5", 0); map.put("7", 0);

        return map;
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