package Programers.Level1;

public class 체육복 {

    public static void main(String[] args) {
        체육복 t = new 체육복();
        int[] lost = new int[] {1, 2};
        int[] reserve = new int[] {};
        System.out.println(t.solution(2, lost, reserve));
    }


    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 1];
        int answer = 0;
        int temp = 0;

        for(int i = 1; i < student.length; i++) {
            student[i]++;
            temp = isReserve(i, reserve);
            if(temp != 0)
                student[temp]++;
        }

        temp = 0;
        for(int i = 1; i < student.length; i++) {
            temp = isLost(i, lost);
            if(temp != 0) {
                student[temp]--;
            }

        }

        for(int i = 1; i < student.length; i++) {
            if(student[i] == 0) {
                if(i != 1 && student[i - 1] > 1) {
                    student[i - 1]--;
                    student[i]++;
                }else if(i != student.length - 1 &&student[i + 1] > 1) {
                    student[i + 1]--;
                    student[i]++;
                }
            }

            if(student[i] != 0) answer++;
        }

        return answer;
    }

    public int isLost(int student, int[] lost) {
        for(int i : lost) {
            if(student == i) return i;
        }
        return 0;
    }

    public int isReserve(int student, int[] reserve) {
        for(int i : reserve) {
            if(student == i) return i;
        }
        return 0;
    }

}
