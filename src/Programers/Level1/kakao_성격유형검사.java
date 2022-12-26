package Programers.Level1;

import java.util.HashMap;
import java.util.Map;

public class kakao_성격유형검사 {
    // 1 : 라이언(R)     튜브(T)
    // 2 : 콘형(C)       프로도형(F)
    // 3 : 제이형(J)     무지형(M)
    // 4 : 어피치형(A)   네오형(N)
    Map<String, Integer> map;
    public static final String RION = "R"; public static final String TUBE = "T";
    public static final String CORN = "C"; public static final String FRODO = "F";
    public static final String JAY = "J"; public static final String MOOSY = "M";
    public static final String APEACHE = "A"; public static final String NEO = "N";

    public String solution(String[] survey, int[] choices) {
        initSurvey();
        countingSurvey(survey, choices);
        return getResult();
    }

    private void initSurvey() {
        map = new HashMap<String, Integer>();

        map.put(RION, 0); map.put(TUBE, 0);
        map.put(CORN, 0); map.put(FRODO, 0);
        map.put(JAY, 0); map.put(MOOSY, 0);
        map.put(APEACHE, 0); map.put(NEO, 0);
    }

    private void countingSurvey(String[] survey, int[] choices) {
        for(int i = 0; i < survey.length; i++) {

            if(choices[i] < 4) {
                map.put(String.valueOf(survey[i].charAt(0)), getSurveyPoint(String.valueOf(survey[i].charAt(0))) + (3 / choices[i]) + (3 % choices[i]));
            }else if(choices[i] > 4) {
                map.put(String.valueOf(survey[i].charAt(1)), getSurveyPoint(String.valueOf(survey[i].charAt(1))) + choices[i] - 4);
            }

        }
    }

    private int getSurveyPoint(String type) {
        return map.get(type);
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        if(map.get(RION) >= map.get(TUBE))  sb.append(RION);
        else sb.append(TUBE);

        if(map.get(CORN) >= map.get(FRODO))  sb.append(CORN);
        else sb.append(FRODO);

        if(map.get(JAY) >= map.get(MOOSY)) sb.append(JAY);
        else sb.append(MOOSY);

        if(map.get(APEACHE) >= map.get(NEO)) sb.append(APEACHE);
        else sb.append(NEO);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] test1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] test2 = {5, 3, 2, 7, 5};

        System.out.println(new kakao_성격유형검사().solution(test1, test2));
    }
}
