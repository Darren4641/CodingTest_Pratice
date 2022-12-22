package Programers.Level1;

public class 옹알이2 {
    public static final String AYA = "aya";
    public static final String YE = "ye";
    public static final String WOO = "woo";
    public static final String MA = "ma";

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String babb : babbling) {
            if(babb.contains(AYA+AYA) || babb.contains(YE+YE) || babb.contains(WOO+WOO) || babb.contains(MA+MA) ) {
            }else {
                babb = babb.replace(AYA, " ");
                babb = babb.replace(YE, " ");
                babb = babb.replace(WOO, " ");
                babb = babb.replace(MA, " ");
                babb = babb.replace(" ", "");
                if(babb.length() == 0)
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //aya ye woo ma
        String[] testCase = { "aya", "yee", "u", "maa" };
        String[] testCase2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println("solution = " + solution(testCase));

    }

}

/*
머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
연속해서 같은 발음을 하는 것을 어려워합니다.
문자열 배열 babbling이 매개변수로 주어질 때,
머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

babbling                                      	  result
["aya", "yee", "u", "maa"]                       	1
["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]   	2

입출력 예 #1

["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
입출력 예 #2

["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.


 */