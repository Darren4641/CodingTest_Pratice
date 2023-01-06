package Programers.Level1;

public class 뒤집기3진법 {
    public int solution(int n) {
        StringBuffer sb = new StringBuffer();

        return Integer.parseInt(getThirdNumber(n, sb), 3);
    }

    public String getThirdNumber(int n, StringBuffer sb) {
        if(n/3 == 0) {
            sb.append(n%3);
            return sb.toString();
        }else {
            sb.append(n % 3);
            return getThirdNumber(n/3, sb);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 뒤집기3진법().solution(45));

    }
}
