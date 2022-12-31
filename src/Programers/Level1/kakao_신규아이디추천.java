package Programers.Level1;

public class kakao_신규아이디추천 {

    private static final String NUMBER = "0123456789";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public String solution(String new_id) {
        String answer = "";
        answer = level7(level6(level5(level4(level3(level2(level1(new_id)))))));
        return answer;
    }

    private String level1(String new_id) {
        return new_id.toLowerCase();
    }

    private String level2(String new_id) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            if(((ALPHABET.contains(String.valueOf(new_id.charAt(i)))) ||
                    (NUMBER.contains(String.valueOf(new_id.charAt(i)))) ||
                    (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.')))
                sb.append(String.valueOf(new_id.charAt(i)));
        }

        return sb.toString();
    }

    private String level3(String new_id) {
        if(!new_id.contains("..")) return new_id;
        else return level3(new_id.replace("..", "."));
    }

    private String level4(String new_id) {
        if(new_id.startsWith("."))
            new_id = new_id.substring(1);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0, new_id.length() - 1);
        return new_id;

    }

    private String level5(String new_id) {
        if(new_id.equals("")) return "a";
        return new_id;
    }

    private String level6(String new_id) {
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }

    private String level7(String new_id) {
        StringBuffer sb = new StringBuffer(new_id);
        sb.append(String.valueOf(new_id.charAt(new_id.length() - 1)));
        if(new_id.length() <= 2) {
            return level7(sb.toString());
        }

        return new_id;
    }

    public static void main(String[] args) {
        System.out.println(new kakao_신규아이디추천().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new kakao_신규아이디추천().solution("zxz4641..@$SXxg"));
    }
}
